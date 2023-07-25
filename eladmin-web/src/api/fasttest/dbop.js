import request from '@/utils/request'

export default function edit(data) {
  return request({
    url: 'api/demouser',
    method: 'put',
    data
  })
}
