---
title: 丑鱼外卖 v1.0.0
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

# 丑鱼外卖

> v1.0.0

Base URLs:

# 商铺

## GET 获取商铺信息

GET /api/shop

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|shopId|query|integer| 是 |商店主键|
|token|query|string| 否 |鉴权 可空|

> 返回示例

> 200 Response

```json
{
  "id": 0,
  "nickname": "string",
  "address": "string",
  "phone": "string"
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
|» nickname|string|true|none||none|
|» address|string|true|none||none|
|» phone|string|true|none||商家联系电话|

# 数据模型

