# Finanças Pro

API do projeto Finanças Pro - Controle de Despesas Pessoais

## Requisitos

- [ ] CRUD de categorias
- [ ] CRUD de movimentações
- [ ] CRUD de usuários
- [ ] Autenticação
- [ ] Dashboard

## Documentação

### Endpoints

- [Listar Categorias](#listar-categorias)
- [Cadastrar Categoria](#cadastrar-categoria)
- [Detalhes da Categoria](#detalhes-da-categoria)
- [Apagar Categoria](#apagar-categoria)
- [Atualizar Categoria](#atualizar-categoria)

### Listar Categorias

`GET` /categoria

Retorna um array com todas as categorias cadastradas.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Alimentação",
        "icone": "fast-food"
    },
    {
        "id": 2,
        "nome": "Educação",
        "icone": "book"
    }
]
```

#### Código de Status

| código | descrição
|:------:|:----------
|200|Categorias retornadas com sucesso.
|401|Usuário não autenticado. Realize autenticação em `/login`.

---

### Cadastrar Categoria

`POST` /categoria

Cadastrar uma nova categoria para o usuário logado com os dados enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|:------:|:----:|:-----------:|:-----------
| nome | string | ✓ | Um nome curto para a categoria.
| icone | string | X | O nome do ícone conforme 'material icons'.

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

#### Código de Status

| código | descrição
|:------:|:----------
| 201 | Categoria cadastrada com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realize autenticação em `/login`.

---

### Detalhes da Categoria

`GET` /categoria/`{id}`

Retorna os dados detalhados da categoria com o `id` informado no parâmetro de path.

#### Exemplo de Resposta
```js
// requisição para /categoria/1
{
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

#### Código de Status

| código | descrição
|:------:|:----------
| 201 | Dados da categoria retornados com sucesso.
| 401 | Usuário não autenticado. Realize autenticação em `/login`.
| 404 | Não existe categoria com o `id` informado. Consulte lista em `/categoria`.

---

### Apagar Categoria

`DELETE` /categoria/`{id}`

Apaga categoria indicada pelo `id` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|:------:|:----------
| 204 | Categoria apagada com sucesso.
| 401 | Usuário não autenticado. Realize autenticação em `/login`.
| 404 | Não existe categoria com o `id` informado. Consulte lista em `/categoria`.

---

### Atualizar Categoria

`PUT` /categoria/`{id}`

Atualiza os dados da categoria com o `id` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|:------:|:----:|:-----------:|:-----------
| nome | string | ✓ | Um nome curto para a categoria.
| icone | string | ✓ | O nome do ícone conforme 'material icons'.

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
```
#### Código de Status

| código | descrição
|:------:|:----------
| 200 | Categoria atualizada com sucesso.
| 400 | Validação falhou. Verifique as regras para o corpo da requisição.
| 401 | Usuário não autenticado. Realize autenticação em `/login`.
| 404 | Não existe categoria com o `id` informado. Consulte lista em `/categoria`.