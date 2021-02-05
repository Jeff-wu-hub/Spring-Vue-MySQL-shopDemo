import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    params:data
  })
}
export function logout(data) {
  return request({
    url: '/login',
    method: 'post',
    params:data
  })
}
export function createUser(data){
  return request({
    url:'',
    method:'post',
    params:data
  })
}
