
export const upload = data => {
    return http.post(`/files/upload`, {
      params: data
    })
  }
  export const download = data => {
    return http.get(`/files/download`)
  }
  
  export default {
    upload,
    download
  }
  