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

* <a href="http://surkaa.shop:9000">正式环境: http://surkaa.shop:9000</a>

* <a href="http://localhost:9000">开发环境: http://localhost:9000</a>

* <a href="http://test-cn.your-api-server.com">测试环境: http://test-cn.your-api-server.com</a>

# 商铺

## GET 获取某个商铺信息 包括所有的商品信息

GET /shops/{shopId}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|shopId|path|integer| 是 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "shop": {
      "id": 0,
      "nickname": "string",
      "address": "string",
      "phone": "string"
    },
    "shopProducts": [
      {
        "id": 0,
        "name": "string",
        "description": "string",
        "imgUrl": "string",
        "count": 0,
        "price": 0
      }
    ]
  },
  "message": "登陆失败",
  "description": "密码错误"
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
|» data|object|true|none||none|
|»» shop|[店铺信息返回体](#schema%e5%ba%97%e9%93%ba%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|
|»» shopProducts|[[商品信息返回体](#schema%e5%95%86%e5%93%81%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

## POST 获取所有商铺的信息

POST /shops

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |只有登录的学生用户token|

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
|» code|integer|true|none||none|
|» data|object¦null|true|none||none|
|»» shops|[[店铺信息返回体](#schema%e5%ba%97%e9%93%ba%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

## POST 商家登录接口

POST /shops/login

> Body 请求参数

```json
{
  "username": "sjBto5",
  "password": "123456"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 1231241234123,
    "username": "string",
    "token": "afsdgsdgsd.asdasfwetwf.asdadasd"
  },
  "message": "登陆失败",
  "description": "密码错误"
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
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

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

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» code|body|integer| 是 |none|
|» data|body|[登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93)| 是 |none|
|» message|body|string¦null| 是 |none|
|» description|body|string¦null| 是 |none|

#### 枚举值

|属性|值|
|---|---|
|» code|-1|
|» code|0|
|» code|200|
|» code|300|
|» code|301|
|» code|302|
|» code|303|
|» code|304|
|» code|305|
|» code|306|
|» code|307|
|» code|308|
|» code|309|
|» code|310|
|» code|311|
|» code|312|
|» code|313|

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

POST /students/login

> Body 请求参数

```json
{
  "username": "V5Oaph",
  "password": "123456"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» username|body|string| 是 |none|
|» password|body|string| 是 |none|

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
|» data|any|true|none||none|

*anyOf*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|»» *anonymous*|[登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93)|false|none||none|

*or*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|»» *anonymous*|null|false|none||none|

*continued*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|301|
|code|0|

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
|» data|any|true|none||none|

*anyOf*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|»» *anonymous*|[登陆注册返回体](#schema%e7%99%bb%e9%99%86%e6%b3%a8%e5%86%8c%e8%bf%94%e5%9b%9e%e4%bd%93)|false|none||none|

*or*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|»» *anonymous*|null|false|none||none|

*continued*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

## GET 获取学生信息

GET /students

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
|» code|integer|true|none||none|
|» data|[学生信息返回体](#schema%e5%ad%a6%e7%94%9f%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

## POST 订单生成接口

POST /students/order

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» products|body|[object]| 是 |none|
|»» id|body|integer| 是 |商品主键(shop_products_id)|
|»» count|body|integer| 是 |none|
|»» description|body|string| 是 |none|
|» type|body|integer| 是 |订单的状态-0-堂食(用户取 食堂吃 不外带) 1-带走(打包, 需配送费) 2-找跑腿(run_id不可空)|
|» shopId|body|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "totalPrice": 0,
    "orderId": 0
  },
  "message": "登陆失败",
  "description": "密码错误"
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
|» data|object¦null|true|none||none|
|»» totalPrice|integer|true|none||none|
|»» orderId|integer|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

## PUT 消费者确认收货

PUT /students/order

> Body 请求参数

```json
{
  "orderId": 0,
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» orderId|body|integer| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "message": "登陆失败",
  "description": "密码错误"
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
|» data|string|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

## GET 查询订单情况

GET /students/order/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|integer| 是 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "order": {
      "id": 0,
      "studentId": 0,
      "runId": 0,
      "shopId": 0,
      "totalPrice": 0,
      "status": 0,
      "type": 0,
      "targetTime": "string",
      "createdAt": "string",
      "updatedAt": "string",
      "isDeleted": 0
    },
    "orderShopProductsItems": [
      {
        "id": 0,
        "price": 0,
        "count": 0,
        "description": "string"
      }
    ]
  },
  "message": "登陆失败",
  "description": "密码错误"
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
|» data|object¦null|true|none||none|
|»» order|[订单返回体](#schema%e8%ae%a2%e5%8d%95%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|
|»» orderShopProductsItems|[[单个商品的购物车](#schema%e5%8d%95%e4%b8%aa%e5%95%86%e5%93%81%e7%9a%84%e8%b4%ad%e7%89%a9%e8%bd%a6)]|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

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

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 否 |none|
|body|body|object| 否 |none|

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

# 支付

## POST 自己的余额

POST /money

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "uid": 0,
    "cny": 0,
    "depositCny": 0,
    "createdAt": "",
    "updatedAt": "",
    "isDeleted": 0
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

*[统一的返回体]<[The{@code Long} class wraps a value of the primitive type{@code
* long} in an object. An object of type{@code Long} contains a
single field whose type is{@code long}.

<p> In addition, this class provides several methods for converting
a{@code long} to a{@code String} and a{@code String} to a{@code
* long}, as well as other constants and methods useful when dealing
with a{@code long}.

<p>This is a <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
class; programmers should treat instances that are
{@linkplain #equals(Object) equal} as interchangeable and should not
use instances for synchronization, or unpredictable behavior may
occur. For example, in a future release, synchronization may fail.

<p>Implementation note: The implementations of the "bit twiddling"
methods (such as{@link #highestOneBit(long) highestOneBit} and
{@link #numberOfTrailingZeros(long) numberOfTrailingZeros}) are
based on material from Henry S. Warren, Jr.'s <i>Hacker's
Delight</i>, (Addison Wesley, 2002).]>
-9223372036854775808 :A constant holding the minimum value a{@code long} can
have, -2<sup>63</sup>.
9223372036854775807 :A constant holding the maximum value a{@code long} can
have, 2<sup>63</sup>-1.
64 :The number of bits used to represent a{@code long} value in two's
complement binary form.
8 :The number of bytes used to represent a{@code long} value in two's
complement binary form.*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

## POST 支付订单

POST /money/pay

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "balance": 0,
    "bill": {
      "id": 0,
      "fromId": 0,
      "toId": 0,
      "money": 0,
      "type": 0,
      "createdAt": ""
    }
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

*[统一的返回体]<[支付成功后的账单返回体]>*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

## POST 开户

POST /money/new

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "uid": 0,
    "cny": 0,
    "depositCny": 0,
    "createdAt": "",
    "updatedAt": "",
    "isDeleted": 0
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

*[统一的返回体]<[The{@code Long} class wraps a value of the primitive type{@code
* long} in an object. An object of type{@code Long} contains a
single field whose type is{@code long}.

<p> In addition, this class provides several methods for converting
a{@code long} to a{@code String} and a{@code String} to a{@code
* long}, as well as other constants and methods useful when dealing
with a{@code long}.

<p>This is a <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
class; programmers should treat instances that are
{@linkplain #equals(Object) equal} as interchangeable and should not
use instances for synchronization, or unpredictable behavior may
occur. For example, in a future release, synchronization may fail.

<p>Implementation note: The implementations of the "bit twiddling"
methods (such as{@link #highestOneBit(long) highestOneBit} and
{@link #numberOfTrailingZeros(long) numberOfTrailingZeros}) are
based on material from Henry S. Warren, Jr.'s <i>Hacker's
Delight</i>, (Addison Wesley, 2002).]>
-9223372036854775808 :A constant holding the minimum value a{@code long} can
have, -2<sup>63</sup>.
9223372036854775807 :A constant holding the maximum value a{@code long} can
have, 2<sup>63</sup>-1.
64 :The number of bits used to represent a{@code long} value in two's
complement binary form.
8 :The number of bytes used to represent a{@code long} value in two's
complement binary form.*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

# 收货地址

## POST 增加学生收货地址

POST /shopinfo

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": 0,
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

*[统一的返回体]<[The{@code Long} class wraps a value of the primitive type{@code
* long} in an object. An object of type{@code Long} contains a
single field whose type is{@code long}.

<p> In addition, this class provides several methods for converting
a{@code long} to a{@code String} and a{@code String} to a{@code
* long}, as well as other constants and methods useful when dealing
with a{@code long}.

<p>This is a <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
class; programmers should treat instances that are
{@linkplain #equals(Object) equal} as interchangeable and should not
use instances for synchronization, or unpredictable behavior may
occur. For example, in a future release, synchronization may fail.

<p>Implementation note: The implementations of the "bit twiddling"
methods (such as{@link #highestOneBit(long) highestOneBit} and
{@link #numberOfTrailingZeros(long) numberOfTrailingZeros}) are
based on material from Henry S. Warren, Jr.'s <i>Hacker's
Delight</i>, (Addison Wesley, 2002).]>
-9223372036854775808 :A constant holding the minimum value a{@code long} can
have, -2<sup>63</sup>.
9223372036854775807 :A constant holding the maximum value a{@code long} can
have, 2<sup>63</sup>-1.
64 :The number of bits used to represent a{@code long} value in two's
complement binary form.
8 :The number of bytes used to represent a{@code long} value in two's
complement binary form.*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

## PUT 更新学生收货地址

PUT /shopinfo

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": null,
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

*[统一的返回体]<?>*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

## DELETE 删除学生收货地址

DELETE /shopinfo

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": null,
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

*[统一的返回体]<?>*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|

## GET 获取自己的所有收货地址

GET /shopinfo

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "string",
      "location": "string",
      "phone": "string"
    }
  ],
  "message": "登陆失败",
  "description": "密码错误"
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
|» data|[[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|
|» message|string¦null|true|none||none|
|» description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

# 跑腿

## GET 获取可接的所有订单

GET /stdetns/run/order

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNum|query|integer| 否 |默认起始1(后端也需要默认)|
|pageSize|query|integer| 否 |默认大小10条(后端也需要默认, 后端的size最大只允许50)|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "order": {
    "id": 0,
    "studentId": 0,
    "runId": 0,
    "shopId": 0,
    "totalPrice": 0,
    "targetTime": "string",
    "createdAt": "string",
    "updatedAt": "string",
    "isDeleted": 0
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

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» order|object|true|none||none|
|»» id|integer|true|none||none|
|»» studentId|integer|true|none||none|
|»» runId|integer¦null|true|none||none|
|»» shopId|integer|true|none||none|
|»» totalPrice|number|true|none||none|
|»» targetTime|string|true|none||none|
|»» createdAt|string|true|none||none|
|»» updatedAt|string|true|none||none|
|»» isDeleted|integer|true|none||none|
|» shop|[商品信息返回体](#schema%e5%95%86%e5%93%81%e4%bf%a1%e6%81%af%e8%bf%94%e5%9b%9e%e4%bd%93)|true|none||none|

# 数据模型

<h2 id="tocS_金钱账户">金钱账户</h2>

<a id="schema金钱账户"></a>
<a id="schema_金钱账户"></a>
<a id="tocS金钱账户"></a>
<a id="tocs金钱账户"></a>

```json
{
  "id": 0,
  "uid": 0,
  "cny": 0,
  "depositCny": 0,
  "createdAt": "string",
  "updatedAt": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|uid|integer|true|none||none|
|cny|integer|true|none||none|
|depositCny|integer|true|none||none|
|createdAt|string|true|none||none|
|updatedAt|string|true|none||none|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|fromId|integer|true|none||none|
|toId|integer|true|none||none|
|money|integer|true|none||none|
|type|integer|true|none||none|
|createdAt|string|true|none||none|

<h2 id="tocS_订单返回体">订单返回体</h2>

<a id="schema订单返回体"></a>
<a id="schema_订单返回体"></a>
<a id="tocS订单返回体"></a>
<a id="tocs订单返回体"></a>

```json
{
  "id": 0,
  "studentId": 0,
  "runId": 0,
  "shopId": 0,
  "totalPrice": 0,
  "status": 0,
  "type": 0,
  "targetTime": "string",
  "createdAt": "string",
  "updatedAt": "string",
  "isDeleted": 0
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|studentId|integer|true|none||none|
|runId|integer¦null|true|none||none|
|shopId|integer|true|none||none|
|totalPrice|number|true|none||none|
|status|integer|true|none||none|
|type|integer|true|none||none|
|targetTime|string|true|none||none|
|createdAt|string|true|none||none|
|updatedAt|string|true|none||none|
|isDeleted|integer|true|none||none|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||商品主键(shop_products_id)|
|price|number|true|none||单价|
|count|integer|true|none||none|
|description|string|true|none||none|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||none|
|name|string|true|none||none|
|description|string|true|none||none|
|imgUrl|string|true|none||none|
|count|integer|true|none||none|
|price|integer|true|none||none|

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
|arrayOfShoppingInfo|[[收货地址返回体](#schema%e6%94%b6%e8%b4%a7%e5%9c%b0%e5%9d%80%e8%bf%94%e5%9b%9e%e4%bd%93)]|true|none||none|

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

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none||id|
|username|string|true|none||none|
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
|message|string¦null|true|none||none|
|description|string¦null|true|none||none|

#### 枚举值

|属性|值|
|---|---|
|code|-1|
|code|0|
|code|200|
|code|300|
|code|301|
|code|302|
|code|303|
|code|304|
|code|305|
|code|306|
|code|307|
|code|308|
|code|309|
|code|310|
|code|311|
|code|312|
|code|313|

