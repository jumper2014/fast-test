import request from '@/utils/request'

export default function run(data) {
  return request({
    url: 'api/rcommand',
    method: 'post',
    data
  })
}
