# Verifica o status do cluster
GET _cluster/health

# Verifica o status dos nós
GET _nodes/stats

# cria um novo índice (BD)
PUT comidas_preferidas

# lista todos os indices existentes
GET _cat/indices?v=true

# criar dados com post
# gera id de forma automatica
POST comidas_preferidas/_doc
{
  "nome": "Danielen",
  "comida": "pizza"
}

# retornar dados
GET comidas_preferidas/_doc/k_qbHIIBPnuKVHLP0Un8

# criar dados com put
# definindo o id
PUT comidas_preferidas/_doc/1
{
  "nome": "Laura",
  "comida": "Açaí"
}

# criar dados com put usando o mesmo id
# gera um update
PUT comidas_preferidas/_doc/1
{
  "nome": "Larissa",
  "comida": "Parmegiana"
}

# criar dados com put usando o mesmo id usando _create
# não gera um update
PUT comidas_preferidas/_create/1
{
  "nome": "Samantha",
  "comida": "Strogonoff"
}

# ver o dado com numero do id
GET comidas_preferidas/_doc/1

# atualizar um dado
POST comidas_preferidas/_update/1
{
  "doc": {
    "comida": "mousse"
  }
}

# mostra todos inseridos
GET comidas_preferidas/_search


# não aceitar valores duplicados
PUT comidas_preferidas/_settings
{
  "index": {
    "number_of_replicas": 0
  }
}






















