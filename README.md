<h1>Integrantes</h1>
<p>Denner de Oliveira Duarte - RM551938</p>
<p>Lucas Petroni - RM 97861</p>
<p>Matheus Paulo de Lima Delgado - RM552189</p>
<p>Nathaly Oliveira - RM552538</p>
<p>Caio Boris Andrulis - RM552496</p>


<h1>Link do versionamento em nuvem</h1>
<p>https://lojafiap2tdsr.azurewebsites.net/</p>


<h1>Sistema de Gerenciamento de Loja de Brinquedos</h1>

<p>Este projeto é um Sistema de Gerenciamento de Loja de Brinquedos desenvolvido utilizando o framework Spring Boot configurado com Maven, e escrito em Java no Eclipse. O objetivo é fornecer funcionalidades básicas de CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar brinquedos para crianças de até 12 anos. O projeto utiliza a biblioteca Lombok para reduzir o código repetitivo e implementa o HATEOAS (Hypermedia as the Engine of Application State) para uma API RESTful com um nível de maturidade 3.</p>

<h2>Funcionalidades</h2>
<ul>
    <li>Criar: Adicionar novos brinquedos ao sistema.</li>
    <li>Ler: Recuperar informações sobre brinquedos, incluindo detalhes como nome, tipo, classificação, tamanho e preço.</li>
    <li>Atualizar: Modificar informações de brinquedos existentes.</li>
    <li>Deletar: Remover brinquedos do sistema.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Maven</li>
    <li>Lombok</li>
    <li>Oracle SQL Developer</li>
</ul>

<h2>Começando</h2>

<p>Configuração do Spring Initializer e dependências.</p>
<img src="./images/initializ.png" alt="Configuração do Spring Initializer e dependências" style="width: 100%; max-width: 800px;">

<ol>
    <li>Clone o repositório para sua máquina local.</li>
    <li>Importe o projeto para sua IDE preferida.</li>
    <li>Configure o banco de dados Oracle e as informações de conexão em <code>application.properties</code>.</li>
    <li>Construa o projeto utilizando o Maven.</li>
    <li>Rode a aplicação.</li>
</ol>

<h2>Uso</h2>
<ol>
    <li>Utilize o Postman para fazer requisições HTTP e interagir com os endpoints da API.</li>
    <li>Endpoints:</li>
    <ul>
        <li>GET /brinquedos: Recupera informações sobre todos os brinquedos.</li>
        <li>GET /brinquedos/{id}: Recupera informações sobre um brinquedo específico.</li>
        <li>POST /brinquedos: Adiciona um novo brinquedo ao sistema.</li>
        <li>PUT /brinquedos/{id}: Atualiza informações sobre um brinquedo específico.</li>
        <li>PATCH /brinquedos/{id}: Atualiza informações sobre um brinquedo específico.</li>
        <li>DELETE /brinquedos/{id}: Remove um brinquedo do sistema.</li>
    </ul>
    <li>Garanta que os payloads de requisição necessários estejam no formato JSON ao fazer requisições POST, PUT e PATCH.</li>
</ol>

<h2>Chamadas ao Serviço</h2>
<h3>Requisição GET /brinquedos</h3>
<p>Método: GET<br>
URL: /brinquedos<br>
Requisição: Nenhuma<br>
Resposta: Lista de todos os brinquedos cadastrados no sistema.</p>
<pre><code>
    [
        {
            "id": 1,
            "nome": "Carrinhooo",
            "tipo": "Infantillll ae",
            "classificacao": 10,
            "tamanho": "G",
            "preco": 10.0,
            "links": [
                {
                    "rel": "self",
                    "href": "http://localhost:8080/brinquedos/1"
                },
                {
                    "rel": "getAll",
                    "href": "http://localhost:8080/brinquedos"
                },
                {
                    "rel": "getById",
                    "href": "http://localhost:8080/brinquedos/1"
                },
                {
                    "rel": "create",
                    "href": "http://localhost:8080/brinquedos"
                },
                {
                    "rel": "update",
                    "href": "http://localhost:8080/brinquedos/1"
                },
                {
                    "rel": "delete",
                    "href": "http://localhost:8080/brinquedos/1"
                }
            ]
        }, ...
]
</code></pre>
<img src="./images/getAll.png" alt="Requisição GET /brinquedos" style="width: 100%; max-width: 800px;">

<h3>Requisição GET /brinquedos/{id}</h3>
<p>Método: GET<br>
URL: /brinquedos/{id}<br>
Requisição: Nenhuma<br>
Resposta: Informações do brinquedo com o ID especificado.</p>
<code><pre>
    {
        "id": 1,
        "nome": "Carrinhooo",
        "tipo": "Infantillll ae",
        "classificacao": 10,
        "tamanho": "G",
        "preco": 10.0,
        "_links": {
            "self": {
                "href": "http://localhost:8080/brinquedos/1"
            },
            "getAll": {
                "href": "http://localhost:8080/brinquedos"
            },
            "getById": {
                "href": "http://localhost:8080/brinquedos/1"
            },
            "create": {
                "href": "http://localhost:8080/brinquedos"
            },
            "update": {
                "href": "http://localhost:8080/brinquedos/1"
            },
            "delete": {
                "href": "http://localhost:8080/brinquedos/1"
            }
        }
    }
</pre></code>
<img src="./images/getId.png" alt="Requisição GET /brinquedos/{id}" style="width: 100%; max-width: 800px;">

<h3>Requisição POST /brinquedos</h3>
<p>Método: POST<br>
URL: /brinquedos<br>
Requisição: Novo brinquedo a ser adicionado ao sistema, em formato JSON.<br>

<code><pre>
    {
        "id": 1001,
        "nome": "Carrinhooo",
        "tipo": "Infantillll",
        "classificacao": 10,
        "tamanho": "G",
        "preco": 10.0
    }
</pre></code>

Resposta: Informações do novo brinquedo adicionado ao sistema.</p>

<code><pre>
    {
        "id": 1001,
        "nome": "Carrinhooo",
        "tipo": "Infantillll",
        "classificacao": 10,
        "tamanho": "G",
        "preco": 10.0,
        "_links": {
            "self": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "getAll": {
                "href": "http://localhost:8080/brinquedos"
            },
            "getById": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "create": {
                "href": "http://localhost:8080/brinquedos"
            },
            "update": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "delete": {
                "href": "http://localhost:8080/brinquedos/1001"
            }
        }
    }
</pre></code>

<img src="./images/create.png" alt="Requisição POST /brinquedos" style="width: 100%; max-width: 800px;">

<h3>Requisição PUT /brinquedos/{id}</h3>
<p>Método: PUT<br>
URL: /brinquedos/{id}<br>
Requisição: Atualização de brinquedo no sistema, em formato JSON.<br>

<code><pre>
    {
        "id": 1001,
        "nome": "Computador",
        "tipo": "Adolescente",
        "classificacao": 12,
        "tamanho": "G",
        "preco": 100.0
    }
</pre></code>

Resposta: Informações do novo brinquedo adicionado ao sistema.</p>

<code><pre>
    {
        "id": 1001,
        "nome": "Computador",
        "tipo": "Adolescente",
        "classificacao": 12,
        "tamanho": "G",
        "preco": 100.0,
        "_links": {
            "self": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "getAll": {
                "href": "http://localhost:8080/brinquedos"
            },
            "getById": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "create": {
                "href": "http://localhost:8080/brinquedos"
            },
            "update": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "delete": {
                "href": "http://localhost:8080/brinquedos/1001"
            }
        }
    }
</pre></code>

<img src="./images/update.png" alt="Requisição POST /brinquedos" style="width: 100%; max-width: 800px;">





<h3>Requisição PATCH /brinquedos/{id}</h3>
<p>Método: PATCH<br>
URL: /brinquedos/{id}<br>
Requisição: Atualização de brinquedo no sistema, em formato JSON.<br>

<code><pre>
    {
        "id": 1001,
        "nome": "Computador Gamer"
    }
</pre></code>

Resposta: Informações do novo brinquedo adicionado ao sistema.</p>

<code><pre>
    {
        "id": 1001,
        "nome": "Computador Gamer",
        "tipo": "Adolescente",
        "classificacao": 12,
        "tamanho": "G",
        "preco": 100.0,
        "_links": {
            "self": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "getAll": {
                "href": "http://localhost:8080/brinquedos"
            },
            "getById": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "create": {
                "href": "http://localhost:8080/brinquedos"
            },
            "update": {
                "href": "http://localhost:8080/brinquedos/1001"
            },
            "delete": {
                "href": "http://localhost:8080/brinquedos/1001"
            }
        }
    }
</pre></code>

<img src="./images/update_patch.png" alt="Requisição POST /brinquedos" style="width: 100%; max-width: 800px;">

<h3>Requisição DELETE /brinquedos/{id}</h3>
<p>Método: DELETE<br>
URL: /brinquedos/{id}<br>
Requisição: Nenhuma<br>
Resposta: Nenhuma</p>
<img src="./images/delete.png" alt="Requisição DELETE /brinquedos/{id}" style="width: 100%; max-width: 800px;">
