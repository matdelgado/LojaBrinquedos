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
</ul>

<h2>Uso</h2>
<ol>
    <li>URLs:</li>
    <ul>
        <li>/brinquedos: Exibe informações sobre todos os brinquedos.</li>
        <li>/brinquedos/descricao/{id}: Exibe informações sobre um brinquedo específico.</li>
        <li>/brinquedos/adicionar: Adiciona um novo brinquedo ao sistema.</li>
        <li>/brinquedos/editar/{id}: Atualiza informações sobre um brinquedo específico.</li>
    </ul>
</ol>
