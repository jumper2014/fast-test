import request from '@/utils/request'
import qs from 'qs'

export function login(data) {
  return request({
    url: '/account/login',
    method: 'post',
    data: qs.stringify({
      'username': data.username,
      'password': data.password
    })
  })
}

export function getInfo() {
  return request({
    url: '/account/info',
    method: 'get'
  })
}

export function logout(token) {
  return request({
    url: '/logout',
    method: 'post'
  })
}

export function updatePwd(params) {
  return request({
    url: '/account/updatePwd',
    method: 'post',
    data: qs.stringify(params)
  })
}

export function getQrcodeStatus(params) {
  return request({
    url: '/account/qrcode/getRet',
    method: 'get',
    params
  })
}

