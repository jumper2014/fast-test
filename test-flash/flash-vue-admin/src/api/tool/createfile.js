import request from '@/utils/request'

export function createFile(params) {
  return request({
    url: '/createfile/create',
    method: 'get',
    params
  })
}


