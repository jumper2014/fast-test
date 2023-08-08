#!/usr/bin/env python
# https://jeremykao.wordpress.com/2015/06/10/pagefactory-pattern-in-python/
# author: Jeremy, github: https://gist.github.com/imsardine/6185d76377e2c8d06d07#file-pageobject_support-py
# updated to support python2 and python3


import sys
__all__ = ['visible', 'cacheable', 'callable_find_by', 'property_find_by']


def cacheable_decorator(lookup):
    def func(self):
        if not hasattr(self, '_elements_cache'):
            self._elements_cache = {}  # {callable_id: element(s)}
        cache = self._elements_cache

        key = id(lookup)
        if key not in cache:
            cache[key] = lookup(self)
        return cache[key]

    return func


cacheable = cacheable_decorator

_strategy_kwargs = ['id_', 'xpath', 'link_text', 'partial_link_text',
                    'name', 'tag_name', 'class_name', 'css_selector']


def _callable_find_by(how, using, multiple, cacheable, context, driver_attr, **kwargs):
    def func(self):
        # context - driver or a certain element
        if context:
            ctx = context() if callable(context) else context.__get__(self)  # or property
        else:
            ctx = getattr(self, driver_attr)

        # 'how' AND 'using' take precedence over keyword arguments
        if how and using:
            lookup = ctx.find_elements if multiple else ctx.find_element
            return lookup(how, using)

        if sys.version_info < (3, 0):  # 如果小于Python3
            key = kwargs.keys()[0]
        else:
            key = list(kwargs.keys())[0]
        if len(kwargs) != 1 or key not in _strategy_kwargs:
            raise ValueError(
                "If 'how' AND 'using' are not specified, one and only one of the following "
                "valid keyword arguments should be provided: %s." % _strategy_kwargs)

        value = kwargs[key]
        suffix = key[:-1] if key.endswith('_') else key  # find_element(s)_by_xxx
        prefix = 'find_elements_by' if multiple else 'find_element_by'
        lookup = getattr(ctx, '%s_%s' % (prefix, suffix))
        return lookup(value)

    return cacheable_decorator(func) if cacheable else func


def callable_find_by(how=None, using=None, multiple=False, cacheable=False, context=None, driver_attr='_driver',
                     **kwargs):
    return _callable_find_by(how, using, multiple, cacheable, context, driver_attr, **kwargs)


def property_find_by(how=None, using=None, multiple=False, cacheable=False, context=None, driver_attr='_driver',
                     **kwargs):
    return property(_callable_find_by(how, using, multiple, cacheable, context, driver_attr, **kwargs))


def visible(element):
    def expected_condition(ignored):
        candidate = element() if callable(element) else element
        return candidate if (candidate and candidate.is_displayed()) else None

    return expected_condition
