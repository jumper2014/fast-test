import request from '@/utils/request'

export default function create(data) {
  return request({
    url: 'api/batch',
    method: 'post',
    data
  })
}
