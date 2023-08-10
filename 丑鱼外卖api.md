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
toc_footers: []
includes: []
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

# 商铺

## GET 获取所有商铺的信息

GET /shops

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |token鉴权 不能所有人都能获取|

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

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» shops|[[店铺信息返回体](#schema%e5%ba%97%e9%93%ba%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|

## POST 商家登录接口

POST /shops/login

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 学生

## POST 学生登录

POST /student/login

> Body 请求参数

```json
{
  "username": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» username|body|string| 是 |学生账号|
|» password|body|string| 是 |学生密码|

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

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|
|» message|string|true|none||none|
|» description|string|true|none||none|

## POST 学生注册

POST /student/register

> Body 请求参数

```json
{
  "username": "string",
  "password": "string",
  "checkPwd": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» username|body|string| 是 |学生账号|
|» password|body|string| 是 |学生密码|
|» checkPwd|body|string| 是 |确认密码|

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

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|
|» message|string|true|none||none|
|» description|string|true|none||none|

## GET 获取学生信息

GET /student

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|

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

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» id|integer|true|none||none|
|» username|string|true|none||none|
|» role|integer|true|none||none|
|» createdAt|string|true|none||none|
|» shoppingInfoId|integer|true|none||收货地址的外键|
|» arrayOfShoppingInfo|[[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|

# 数据模型

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
  "count": "string",
  "price": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|name|string|true|none||none|
|description|string|true|none||none|
|imgUrl|string|true|none||none|
|count|string|true|none||none|
|price|string|true|none||none|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|nickname|string|true|none||none|
|address|string|true|none||none|
|phone|string|true|none||商家联系电话|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|name|string|true|none||none|
|location|string|true|none||none|
|phone|string|true|none||none|

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
  "shoppingInfoId": 0,
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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|username|string|true|none||none|
|role|integer|true|none||none|
|createdAt|string|true|none||none|
|shoppingInfoId|integer|true|none||收货地址的外键|
|arrayOfShoppingInfo|[[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|

<h2 id="tocS_登陆注册返回体">登陆注册返回体</h2>

<a id="schema登陆注册返回体"></a>
<a id="schema_登陆注册返回体"></a>
<a id="tocS登陆注册返回体"></a>
<a id="tocs登陆注册返回体"></a>

```json
{
  "id": 1231241234123,
  "token": "afsdgsdgsd.asdasfwetwf.asdadasd"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||id|
|token|string|true|none||token|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer|true|none||none|
|data|string|true|none||none|
|message|string|true|none||none|
|description|string|true|none||none|

