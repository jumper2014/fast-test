import request from '@/utils/request'

export function setUserStatus(params) {
  return request({
    url: '/dbop/userstatus',
    method: 'post',
    params
  })
}


