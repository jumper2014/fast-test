import request from '@/utils/request'

export function getRuleList(params) {
  return request({
    url: '/crud/list',
    method: 'get',
    params
  })
}


export function saveFlow(params) {
  return request({
    url: '/crud/add',
    method: 'post',
    params
  })
}

export function remove(flowId) {
  return request({
    url: '/crud/delete',
    method: 'delete',
    params: {
      flowId
    }
  })
}