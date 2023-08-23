---
title: 丑鱼外卖api v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: [ ]
includes: [ ]
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# 丑鱼外卖api

> v1.0.0

Base URLs:

* <a href="http://localhost:9000">开发环境: http://localhost:9000</a>

* <a href="http://test-cn.your-api-server.com">测试环境: http://test-cn.your-api-server.com</a>

* <a href="http://prod-cn.your-api-server.com">正式环境: http://prod-cn.your-api-server.com</a>

# 商铺

## GET 获取某个商铺信息 包括所有的商品信息

GET /shops

### 请求参数

| 名称     | 位置     | 类型      | 必选 | 说明   |
|--------|--------|---------|----|------|
| shopId | query  | integer | 是  | 商店主键 |
| token  | header | string  | 否  | none |

> 返回示例

> 200 Response

```json
{
  "shop": {
    "id": 0,
    "nickname": "string",
    "address": "string",
    "phone": "string"
  },
  "products": [
    {
      "id": 0,
      "name": "string",
      "description": "string",
      "imgUrl": "string",
      "count": 0,
      "price": 0
    }
  ]
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称         | 类型                                                                                  | 必选   | 约束   | 中文名 | 说明   |
|------------|-------------------------------------------------------------------------------------|------|------|-----|------|
| » shop     | [店铺信息返回体](#schema%e5%ba%97%e9%93%ba%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)   | true | none |     | none |
| » products | [[商品信息返回体](#schema%e5%95%86%e5%93%81%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)] | true | none |     | none |

## POST 获取所有商铺的信息

POST /shops

### 请求参数

| 名称    | 位置     | 类型     | 必选 | 说明                |
|-------|--------|--------|----|-------------------|
| token | header | string | 是  | token鉴权 不能所有人都能获取 |

> 返回示例

> 成功

```json
{
  "shops": [
    {
      "id": 67,
      "nickname": "邹涛",
      "address": "宁夏回族自治区吉林市虹口区",
      "phone": "13874644913"
    },
    {
      "id": 67,
      "nickname": "邹涛",
      "address": "宁夏回族自治区吉林市虹口区",
      "phone": "13874644913"
    },
    {
      "id": 67,
      "nickname": "邹涛",
      "address": "宁夏回族自治区吉林市虹口区",
      "phone": "13874644913"
    }
  ]
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称      | 类型                                                                                  | 必选   | 约束   | 中文名 | 说明   |
|---------|-------------------------------------------------------------------------------------|------|------|-----|------|
| » shops | [[店铺信息返回体](#schema%e5%ba%97%e9%93%ba%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)] | true | none |     | none |

## POST 商家登录接口

POST /shops/login

> Body 请求参数

```json
{
  "username": "ucnQuNHtbe",
  "password": "123456"
}
```

### 请求参数

| 名称   | 位置   | 类型     | 必选 | 说明   |
|------|------|--------|----|------|
| body | body | object | 否  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

## POST 商家注册接口

POST /shops/register

> Body 请求参数

```json
{
  "username": "string",
  "password": "string",
  "checkPwd": "string"
}
```

### 请求参数

| 名称   | 位置   | 类型     | 必选 | 说明   |
|------|------|--------|----|------|
| body | body | object | 否  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

# 学生

## POST 学生登录

POST /students/login

> Body 请求参数

```json
{
  "username": "V5Oaph",
  "password": "123456"
}
```

### 请求参数

| 名称         | 位置   | 类型     | 必选 | 说明   |
|------------|------|--------|----|------|
| body       | body | object | 否  | none |
| » username | body | string | 是  | 学生账号 |
| » password | body | string | 是  | 学生密码 |

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "id": 21,
    "token": "asdgsdfsfas.asdasfsdfgsdf.asdasdqwd"
  },
  "message": "",
  "description": ""
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称            | 类型                                                                                | 必选   | 约束   | 中文名 | 说明   |
|---------------|-----------------------------------------------------------------------------------|------|------|-----|------|
| » code        | integer                                                                           | true | none |     | none |
| » data        | [登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93) | true | none |     | none |
| » message     | string                                                                            | true | none |     | none |
| » description | string                                                                            | true | none |     | none |

## POST 学生注册

POST /students/register

> Body 请求参数

```json
{
  "username": "string",
  "password": "string",
  "checkPwd": "string"
}
```

### 请求参数

| 名称         | 位置   | 类型     | 必选 | 说明   |
|------------|------|--------|----|------|
| body       | body | object | 否  | none |
| » username | body | string | 是  | 学生账号 |
| » password | body | string | 是  | 学生密码 |
| » checkPwd | body | string | 是  | 确认密码 |

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "id": 21,
    "token": "asdgsdfsfas.asdasfsdfgsdf.asdasdqwd"
  },
  "message": "",
  "description": ""
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称            | 类型                                                                                | 必选   | 约束   | 中文名 | 说明   |
|---------------|-----------------------------------------------------------------------------------|------|------|-----|------|
| » code        | integer                                                                           | true | none |     | none |
| » data        | [登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93) | true | none |     | none |
| » message     | string                                                                            | true | none |     | none |
| » description | string                                                                            | true | none |     | none |

## GET 获取学生信息

GET /students

### 请求参数

| 名称    | 位置     | 类型            | 必选 | 说明   |
|-------|--------|---------------|----|------|
| token | header | array[string] | 否  | none |

> 返回示例

> 成功

```json
{
  "id": 26,
  "username": "于娜",
  "role": 1,
  "createdAt": "1983-03-12 02:58:36",
  "shoppingInfoId": 80,
  "arrayOfShoppingInfo": [
    {
      "id": 80,
      "name": "克复府拉",
      "location": "普天大厦",
      "phone": "18676713333"
    }
  ]
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称                    | 类型                                                                                  | 必选   | 约束   | 中文名 | 说明   |
|-----------------------|-------------------------------------------------------------------------------------|------|------|-----|------|
| » id                  | integer                                                                             | true | none |     | none |
| » username            | string                                                                              | true | none |     | none |
| » role                | integer                                                                             | true | none |     | none |
| » createdAt           | string                                                                              | true | none |     | none |
| » arrayOfShoppingInfo | [[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)] | true | none |     | none |

## POST 订单生成接口

POST /students/order

> Body 请求参数

```json
{}
```

### 请求参数

| 名称         | 位置     | 类型                                                                                            | 必选 | 说明                                                      |
|------------|--------|-----------------------------------------------------------------------------------------------|----|---------------------------------------------------------|
| token      | header | string                                                                                        | 是  | none                                                    |
| body       | body   | object                                                                                        | 否  | none                                                    |
| » products | body   | [[单个商品的购物车](#schema%e5%8d%95%e4%b8%aa%e5%95%86%e5%93%81%e7%9a%84%e8%b4%ad%e7%89%a9%e8%bd%a6)] | 是  | none                                                    |
| » type     | body   | integer                                                                                       | 是  | 订单的状态-0-堂食(用户取 食堂吃 不外带) 1-带走(打包, 需配送费) 2-找跑腿(run_id不可空) |
| » shop_id  | body   | integer                                                                                       | 是  | none                                                    |

> 返回示例

> 200 Response

```json
{
  "total_price": 0,
  "order_id": 0
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称            | 类型      | 必选   | 约束   | 中文名 | 说明   |
|---------------|---------|------|------|-----|------|
| » total_price | integer | true | none |     | none |
| » order_id    | integer | true | none |     | none |

## GET 查询订单情况

GET /students/order

### 请求参数

| 名称       | 位置     | 类型      | 必选 | 说明   |
|----------|--------|---------|----|------|
| order_id | query  | integer | 否  | none |
| token    | header | string  | 否  | none |

> 返回示例

> 200 Response

```json
{
  "order": {
    "id": 0,
    "student_id": 0,
    "run_id": 0,
    "shop_id": 0,
    "total_price": 0,
    "status": 0,
    "type": 0,
    "target_time": "string",
    "created_at": "string"
  },
  "products": [
    {
      "id": 0,
      "price": 0,
      "count": 0,
      "description": "string"
    }
  ]
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称         | 类型                                                                                            | 必选   | 约束   | 中文名 | 说明   |
|------------|-----------------------------------------------------------------------------------------------|------|------|-----|------|
| » order    | [订单返回体](#schema%e8%ae%a2%e5%8d%95%e8%bf%94%e5%9b%9e%e4%bd%93)                                 | true | none |     | none |
| » products | [[单个商品的购物车](#schema%e5%8d%95%e4%b8%aa%e5%95%86%e5%93%81%e7%9a%84%e8%b4%ad%e7%89%a9%e8%bd%a6)] | true | none |     | none |

## POST 消费者确认收货

POST /students/order/access

### 请求参数

| 名称       | 位置     | 类型      | 必选 | 说明   |
|----------|--------|---------|----|------|
| order_id | query  | integer | 是  | none |
| password | query  | string  | 否  | none |
| token    | header | string  | 是  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

## GET 获取可接的所有订单

GET /stdetns/run/order

### 请求参数

| 名称       | 位置     | 类型      | 必选 | 说明                               |
|----------|--------|---------|----|----------------------------------|
| pageNum  | query  | integer | 否  | 默认起始1(后端也需要默认)                   |
| pageSize | query  | integer | 否  | 默认大小10条(后端也需要默认, 后端的size最大只允许50) |
| token    | header | string  | 是  | none                             |

> 返回示例

> 200 Response

```json
{
  "order": {
    "id": 0,
    "student_id": 0,
    "run_id": 0,
    "shop_id": 0,
    "created_at": "string"
  },
  "shop": {
    "id": 0,
    "name": "string",
    "description": "string",
    "imgUrl": "string",
    "count": 0,
    "price": 0
  }
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称            | 类型                                                                                | 必选   | 约束   | 中文名 | 说明   |
|---------------|-----------------------------------------------------------------------------------|------|------|-----|------|
| » order       | object                                                                            | true | none |     | none |
| »» id         | integer                                                                           | true | none |     | none |
| »» student_id | integer                                                                           | true | none |     | none |
| »» run_id     | integer                                                                           | true | none |     | none |
| »» shop_id    | integer                                                                           | true | none |     | none |
| »» created_at | string                                                                            | true | none |     | none |
| » shop        | [商品信息返回体](#schema%e5%95%86%e5%93%81%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93) | true | none |     | none |

## POST 学生添加地址和电话接口

POST /students/addinfo

> Body 请求参数

```json
{}
```

### 请求参数

| 名称    | 位置     | 类型     | 必选 | 说明   |
|-------|--------|--------|----|------|
| token | header | string | 否  | none |
| body  | body   | object | 否  | none |

> 返回示例

> 200 Response

```json
{
  "name": "string",
  "location": "string",
  "phone": "string"
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称         | 类型     | 必选   | 约束   | 中文名 | 说明   |
|------------|--------|------|------|-----|------|
| » name     | string | true | none |     | none |
| » location | string | true | none |     | none |
| » phone    | string | true | none |     | none |

## PUT 修改学生地址和电话

PUT /students/addinfo

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "location": "string",
  "phone": "string"
}
```

### 请求参数

| 名称         | 位置   | 类型      | 必选 | 说明   |
|------------|------|---------|----|------|
| body       | body | object  | 否  | none |
| » id       | body | integer | 是  | none |
| » name     | body | string  | 是  | none |
| » location | body | string  | 是  | none |
| » phone    | body | string  | 是  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

## DELETE 删除地址和电话接口

DELETE /students/addinfo

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

| 名称   | 位置   | 类型      | 必选 | 说明   |
|------|------|---------|----|------|
| body | body | object  | 否  | none |
| » id | body | integer | 是  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

## PUT 修改学生密码

PUT /students/pwd

> Body 请求参数

```json
{
  "oldPassword": "",
  "newPassword": "",
  "checkPassword": ""
}
```

### 请求参数

| 名称    | 位置     | 类型     | 必选 | 说明   |
|-------|--------|--------|----|------|
| token | header | string | 否  | none |
| body  | body   | object | 否  | none |

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

# 支付

## POST 获取自己余额

POST /money

### 请求参数

| 名称    | 位置     | 类型     | 必选 | 说明   |
|-------|--------|--------|----|------|
| token | header | string | 否  | none |

> 返回示例

> 200 Response

```json
{
  "money": 0
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称      | 类型      | 必选   | 约束   | 中文名 | 说明   |
|---------|---------|------|------|-----|------|
| » money | integer | true | none |     | none |

## POST 下单(支付)

POST /money/pay

> Body 请求参数

```json
{
  "orderId": 1,
  "password": "123456"
}
```

### 请求参数

| 名称         | 位置     | 类型      | 必选 | 说明    |
|------------|--------|---------|----|-------|
| token      | header | string  | 否  | none  |
| body       | body   | object  | 否  | none  |
| » order_id | body   | integer | 是  | 订单主键  |
| » password | body   | string  | 是  | 确认 保障 |

> 返回示例

> 200 Response

```json
{
  "bill": {
    "id": 0,
    "fromId": 0,
    "toId": 0,
    "money": 0,
    "type": 0,
    "createdAt": "string"
  },
  "balance": 0
}
```

### 返回结果

| 状态码 | 状态码含义                                                   | 说明 | 数据模型   |
|-----|---------------------------------------------------------|----|--------|
| 200 | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline |

### 返回数据结构

状态码 **200**

| 名称        | 类型                                                            | 必选   | 约束   | 中文名 | 说明 |
|-----------|---------------------------------------------------------------|------|------|-----|----|
| » bill    | [账单返回体](#schema%e8%b4%a6%e5%8d%95%e8%bf%94%e5%9b%9e%e4%bd%93) | true | none |     | 账单 |
| » balance | integer                                                       | true | none |     | 余额 |

# 数据模型

<h2 id="tocS_账单返回体">账单返回体</h2>

<a id="schema账单返回体"></a>
<a id="schema_账单返回体"></a>
<a id="tocS账单返回体"></a>
<a id="tocs账单返回体"></a>

```json
{
  "id": 0,
  "fromId": 0,
  "toId": 0,
  "money": 0,
  "type": 0,
  "createdAt": "string"
}

```

### 属性

| 名称        | 类型      | 必选   | 约束   | 中文名 | 说明   |
|-----------|---------|------|------|-----|------|
| id        | integer | true | none |     | none |
| fromId    | integer | true | none |     | none |
| toId      | integer | true | none |     | none |
| money     | integer | true | none |     | none |
| type      | integer | true | none |     | none |
| createdAt | string  | true | none |     | none |

<h2 id="tocS_订单返回体">订单返回体</h2>

<a id="schema订单返回体"></a>
<a id="schema_订单返回体"></a>
<a id="tocS订单返回体"></a>
<a id="tocs订单返回体"></a>

```json
{
  "id": 0,
  "student_id": 0,
  "run_id": 0,
  "shop_id": 0,
  "total_price": 0,
  "status": 0,
  "type": 0,
  "target_time": "string",
  "created_at": "string"
}

```

### 属性

| 名称          | 类型      | 必选   | 约束   | 中文名 | 说明   |
|-------------|---------|------|------|-----|------|
| id          | integer | true | none |     | none |
| student_id  | integer | true | none |     | none |
| run_id      | integer | true | none |     | none |
| shop_id     | integer | true | none |     | none |
| total_price | number  | true | none |     | none |
| status      | integer | true | none |     | none |
| type        | integer | true | none |     | none |
| target_time | string  | true | none |     | none |
| created_at  | string  | true | none |     | none |

<h2 id="tocS_单个商品的购物车">单个商品的购物车</h2>

<a id="schema单个商品的购物车"></a>
<a id="schema_单个商品的购物车"></a>
<a id="tocS单个商品的购物车"></a>
<a id="tocs单个商品的购物车"></a>

```json
{
  "id": 0,
  "price": 0,
  "count": 0,
  "description": "string"
}

```

### 属性

| 名称          | 类型      | 必选   | 约束   | 中文名 | 说明                     |
|-------------|---------|------|------|-----|------------------------|
| id          | integer | true | none |     | 商品主键(shop_products_id) |
| price       | number  | true | none |     | 单价                     |
| count       | integer | true | none |     | none                   |
| description | string  | true | none |     | none                   |

<h2 id="tocS_商品信息返回体">商品信息返回体</h2>

<a id="schema商品信息返回体"></a>
<a id="schema_商品信息返回体"></a>
<a id="tocS商品信息返回体"></a>
<a id="tocs商品信息返回体"></a>

```json
{
  "id": 0,
  "name": "string",
  "description": "string",
  "imgUrl": "string",
  "count": 0,
  "price": 0
}

```

### 属性

| 名称          | 类型      | 必选   | 约束   | 中文名 | 说明   |
|-------------|---------|------|------|-----|------|
| id          | integer | true | none |     | none |
| name        | string  | true | none |     | none |
| description | string  | true | none |     | none |
| imgUrl      | string  | true | none |     | none |
| count       | integer | true | none |     | none |
| price       | integer | true | none |     | none |

<h2 id="tocS_店铺信息返回体">店铺信息返回体</h2>

<a id="schema店铺信息返回体"></a>
<a id="schema_店铺信息返回体"></a>
<a id="tocS店铺信息返回体"></a>
<a id="tocs店铺信息返回体"></a>

```json
{
  "id": 0,
  "nickname": "string",
  "address": "string",
  "phone": "string"
}

```

### 属性

| 名称       | 类型      | 必选   | 约束   | 中文名 | 说明     |
|----------|---------|------|------|-----|--------|
| id       | integer | true | none |     | none   |
| nickname | string  | true | none |     | none   |
| address  | string  | true | none |     | none   |
| phone    | string  | true | none |     | 商家联系电话 |

<h2 id="tocS_收货地址返回体">收货地址返回体</h2>

<a id="schema收货地址返回体"></a>
<a id="schema_收货地址返回体"></a>
<a id="tocS收货地址返回体"></a>
<a id="tocs收货地址返回体"></a>

```json
{
  "id": 0,
  "name": "string",
  "location": "string",
  "phone": "string"
}

```

### 属性

| 名称       | 类型      | 必选   | 约束   | 中文名 | 说明   |
|----------|---------|------|------|-----|------|
| id       | integer | true | none |     | none |
| name     | string  | true | none |     | none |
| location | string  | true | none |     | none |
| phone    | string  | true | none |     | none |

<h2 id="tocS_学生信息返回体">学生信息返回体</h2>

<a id="schema学生信息返回体"></a>
<a id="schema_学生信息返回体"></a>
<a id="tocS学生信息返回体"></a>
<a id="tocs学生信息返回体"></a>

```json
{
  "id": 0,
  "username": "string",
  "role": 0,
  "createdAt": "string",
  "arrayOfShoppingInfo": [
    {
      "id": 0,
      "name": "string",
      "location": "string",
      "phone": "string"
    }
  ]
}

```

### 属性

| 名称                  | 类型                                                                                  | 必选   | 约束   | 中文名 | 说明   |
|---------------------|-------------------------------------------------------------------------------------|------|------|-----|------|
| id                  | integer                                                                             | true | none |     | none |
| username            | string                                                                              | true | none |     | none |
| role                | integer                                                                             | true | none |     | none |
| createdAt           | string                                                                              | true | none |     | none |
| arrayOfShoppingInfo | [[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)] | true | none |     | none |

<h2 id="tocS_登陆注册返回体">登陆注册返回体</h2>

<a id="schema登陆注册返回体"></a>
<a id="schema_登陆注册返回体"></a>
<a id="tocS登陆注册返回体"></a>
<a id="tocs登陆注册返回体"></a>

```json
{
  "id": 1231241234123,
  "username": "string",
  "token": "afsdgsdgsd.asdasfwetwf.asdadasd"
}

```

### 属性

| 名称       | 类型      | 必选   | 约束   | 中文名 | 说明    |
|----------|---------|------|------|-----|-------|
| id       | integer | true | none |     | id    |
| username | string  | true | none |     | none  |
| token    | string  | true | none |     | token |

<h2 id="tocS_统一返回体">统一返回体</h2>

<a id="schema统一返回体"></a>
<a id="schema_统一返回体"></a>
<a id="tocS统一返回体"></a>
<a id="tocs统一返回体"></a>

```json
{
  "code": 0,
  "data": "string",
  "message": "登陆失败",
  "description": "密码错误"
}

```

### 属性

| 名称          | 类型      | 必选   | 约束   | 中文名 | 说明   |
|-------------|---------|------|------|-----|------|
| code        | integer | true | none |     | none |
| data        | string  | true | none |     | none |
| message     | string  | true | none |     | none |
| description | string  | true | none |     | none |

