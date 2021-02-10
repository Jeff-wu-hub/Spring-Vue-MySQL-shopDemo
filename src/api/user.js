import request from '@/utils/request'

/**
 * 登陆功能
 * @param data
 * @returns {AxiosPromise}
 */
export function login(data) {
  return request({
    url: '/login',
    method: 'post',
    params:data
  })
}

/**
 * 登出
 * @param data
 * @returns {AxiosPromise}
 */
export function logout(data) {
  return request({
    url: '/login',
    method: 'post',
    params:data
  })
}

/**
 * 创建用户
 * @param data
 * @returns {AxiosPromise}
 */
export function createUser(data){
  return request({
    url:'/user/addUser',
    method:'post',
    params:data
  })
}

/**
 * 获取用户列表
 * @param params
 * @returns {*}
 */

export function getUserList(params){
  return request({
    url:'/user/selectUser',
    methods:'get',
    params
  })
}

/**
 * 删除用户
 * @param params
 * @returns {AxiosPromise}
 */
export function deleteUser(params){
  return request({
    url:'/user/deleteUser',
    method:'post',
    params
  })
}

/**
 * 搜索用户名字
 * @param params
 * @returns {AxiosPromise}
 */
export function selectName(params){
  return request({
    url:'/user/selectName',
    method:'get',
    params
  })
}

/**
 * 更新用户信息
 * @param params
 * @returns {AxiosPromise}
 */
export function updateUser(params){
  return request({
    url:'/user/updateUser',
    method:'post',
    params
  })
}

/**
 * 允许用户是否登陆
 * @param params
 * @returns {AxiosPromise}
 */
export function changeType(params){
  return request({
    url:'/user/changeType',
    method:'post',
    params
  })
}
/**
 * 改变金额
 * @param params
 * @returns {AxiosPromise}
 */
export function updateMoney(params){
  return request({
    url:'/user/changeMoney',
    method:'post',
    params
  })
}
