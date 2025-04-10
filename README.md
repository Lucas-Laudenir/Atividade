# 📝 OBS para o código

## 🔄 PUT /personagem

```json
{
  "namePersonagem": "string",
  "nomeAventureiro": "string",
  "classe": "MAGO",
  "level": 1073741824,
  "forcaPersonagem": 1073741824,
  "defPersonagem": 1073741824,
  "itensMagicos": [
    {
      "nameItem": "string",
      "forcaItem": 1073741824,
      "defIten": 1073741824,
      "tipo": "ARMA"
    }
  ]
}
```

## 🔄 POST /personagem

```json
{
//Remover os ID
  "namePersonagem": "string",
  "nomeAventureiro": "string",
  "classe": "GUERREIRO",
  "level": 1073741824,
  "forcaPersonagem": 1073741824,
  "defPersonagem": 1073741824,
  "itensMagicos": [
    {

      "nameItem": "string",
      "forcaItem": 1073741824,
      "defIten": 1073741824,
      "tipo": "ARMA"
    }
  ],
  "defesaTotal": 1073741824,
  "forcaTotal": 1073741824
}
```
## 🔄 PUT /Iten

```json
{
{
  // remover o ID
  "nameItem": "string",
  "forcaItem": 10,
  "defIten": 0,
  "tipo": "ARMA"
}
```

## 🔄 PATCH /Personagem/{id}/adicionar-item
# NÃO esqueça  de criar o personagem antes

```json
{
  "nameItem": "Espada de Fogo",
  "forcaItem": 50,
  "defIten": 10,
  "tipo": "ARMA"
}  
```

