import request from '@/utils/request'

export function setUserStatus(params) {
  return request({
    url: '/pb/setUserStatus',
    method: 'post',
    params
  })
}


