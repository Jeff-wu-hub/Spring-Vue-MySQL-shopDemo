# 1. 电商后台API接口文档
## 1.1. API  接口说明
- 接口基准地址：http://127.0.0.1:8888/
- 服务端已开启 CORS 跨域支持
- 使用 HTTP Status Code 标识状态
- 数据返回格式统一使用 JSON
### 1.1.1. 支持的请求方法
- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建、修改、删除一个资源。
### 1.1.2. 通用返回状态说明
| *状态码* | *含义*| *说明*|
|-----|------|--------|
|10|SUCCESS|用户登录成功|
|100|SUCCESS_SELECT|查询成功|
|110|SUCCESS_ADD|增加成功|
|120|SUCCESS_UPDATE|更新成功|
|121|SUCCESS_UPDATE_USER_TYPE|修改用户状态成功|
|130|SUCCESS_DELETE_USER|删除成功|
|400|ERROR|登录失败|
|401|ERROR_SELECT|没有数据|
|410|ERROR_ADD|添加失败|
|420|ERROR_UPDATE|修改失败|
|421|ERROR_UPDATE_USER_TYPE|修改状态失败|
|430|ERROR_DELETE|删除失败|
|500|SERVICE|服务器错误|
|501|ERROR_PARAMS|传参错误|
## 1.2. 登录
### 1.2.1. 登录验证接口
- 请求路径：/user/login
- 请求方法：post
- 请求参数

| 参数名| 参数说明 |备注|
| :--------: | :----: | :----: |
| username | 用户名  | 不能为空 |
| password | 密码   | 不能为空 |
- 响应参数
NULL

- 响应数据
```json
{
    "data": null,
    "meta": {
        "msg": "登录成功",
        "code": 10
    }
}
```
## 1.3. 用户管理

### 1.3.1. 用户数据列表

- 请求路径：/user/selectUser
- 请求方法：get
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
| pagenum  | 当前页码   | 不能为空 |
| pagesize | 每页显示条数 | 不能为空 |

- 响应参数

| 参数名       | 参数说明   | 备注   |
| --------- | ------ | ---- |
| id | 用户ID   |      |
| user_name | 用户账号   |      |
| user_password | 用户密码   |      |
| online | 用户可用状态   |      |
| email | 邮箱   |      |
| address | 地址   |      |
| phone电话号 | 用户ID   |      |
| user_level | 用户等级   |      |
| money | 用户积分   |      |
|name|用户名字||
| pagenum   | 当前页码   |      |
| totalElements| 总记录数 |      |
| totalElements| 总记录数 |      |
|content|用户数据||
|pageable|页码信息||
- 响应数据

```json
{
    "data": {
        "content": [
            {
                "id": 1,
                "user_name": "root",
                "user_password": "root",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "吴广帅"
            },
            {
                "id": 2,
                "user_name": "admin1",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 3,
                "user_name": "admin",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 4,
                "user_name": "admin2",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 31,
                "user_name": "admin8",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 5,
            "unpaged": false,
            "paged": true
        },
        "last": false,
        "totalElements": 15,
        "totalPages": 3,
        "size": 5,
        "number": 0,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "first": true,
        "numberOfElements": 5,
        "empty": false
    },
    "meta": {
        "msg": "查询信息成功",
        "code": 101
    }
}
```
### 1.3.2. 用户名字查询

- 请求路径：/user//selectName
- 请求方法：get
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|name|用户名字|不能为空|
| pagenum  | 当前页码   | 不能为空 |
| pagesize | 每页显示条数 | 不能为空 |

- 响应参数

| 参数名       | 参数说明   | 备注   |
| --------- | ------ | ---- |
| id | 用户ID   |      |
| user_name | 用户账号   |      |
| user_password | 用户密码   |      |
| online | 用户可用状态   |      |
| email | 邮箱   |      |
| address | 地址   |      |
| phone电话号 | 用户ID   |      |
| user_level | 用户等级   |      |
| money | 用户积分   |      |
|name|用户名字||
| pagenum   | 当前页码   |      |
| totalElements| 总记录数 |      |
| totalElements| 总记录数 |      |
|content|用户数据||
|pageable|页码信息||
- 响应数据

```json
{
    "data": {
        "content": [
            {
                "id": 2,
                "user_name": "admin1",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 3,
                "user_name": "admin",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 4,
                "user_name": "admin2",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            },
            {
                "id": 31,
                "user_name": "admin8",
                "user_password": "123456",
                "online": 0,
                "email": "15809812381@163.com",
                "address": "浙江省杭州市余杭区",
                "phone": "15809812381",
                "user_level": 0,
                "money": 500,
                "name": "测试1"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "offset": 0,
            "pageSize": 20,
            "pageNumber": 0,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalElements": 4,
        "totalPages": 1,
        "size": 20,
        "number": 0,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "first": true,
        "numberOfElements": 4,
        "empty": false
    },
    "meta": {
        "msg": "查询信息成功",
        "code": 100
    }
}
```
### 1.3.3. 更新用户信息

- 请求路径：/user/updateUser
- 请求方法：post
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|id|用户ID|不能为空|
|username|用户账号|不能为空|
|password|用户密码|不能为空|
|phone|电话号|可以为空|
|email|电子邮箱|不能为空|
|address|地址|可以为空|
|money|积分 or 等级|不能为空|
|name|用户名字|不能为空|


```json
{
    "data": null,
    "meta": {
        "msg": "修改成功",
        "code": 120
    }
}
```
### 1.3.4. 增加用户

- 请求路径：/user/addUser
- 请求方法：post
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|username|用户账号|不能为空|
|password|用户密码|不能为空|
|phone|电话号|可以为空|
|email|电子邮箱|不能为空|
|address|地址|可以为空|
|money|积分 or 等级|不能为空|
|name|用户名字|不能为空|

```json
{
    "data": null,
    "meta": {
        "msg": "增加用户成功",
        "code": 110
    }
}
```
### 1.3.5. 删除用户

- 请求路径：/user/deleteUser
- 请求方法：post
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|id|用户ID|不能为空|


```json
{
    "data": null,
    "meta": {
        "msg": "删除失败",
        "code": 430
    }
}
```
### 1.3.6. 改变用户状态

- 请求路径：/user/changeType
- 请求方法：post
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|id|用户ID|不能为空|
|type|状态|不能为空|

```json
{
    "data": null,
    "meta": {
        "msg": "修改状态成功",
        "code": 121
    }
}
```
### 1.3.6. 修改金额

- 请求路径：/user/changeMoney
- 请求方法：post
- 请求参数

| 参数名      | 参数说明|备注|
| :--------: | :-----: | :---: |
|id|用户ID|不能为空|
|money|状态|不能为空|

```json
{
    "data": null,
    "meta": {
        "msg": "修改成功",
        "code": 120
    }
}
```
