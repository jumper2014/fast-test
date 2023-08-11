import request from '@/utils/request'

export default function put(data) {
  return request({
    url: 'api/rfile',
    method: 'put',
    data
  })
}
