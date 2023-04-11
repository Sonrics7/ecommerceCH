Se añaden coleccions postman en carpeta de sources
----------------------------------------------------------------------------------------
Test Cases
----------------------------------------------------------------------------------------
Cliente(Validaciones en DB, Java y Postman)
Insert(POST)
-Validacion si existe ya por id, no duplicar
-Validacion por nombre: min 2, maximo 75, no vacio
-Validacion por apellido: min 2, maximo 75, no vacio
-Validacion por docnumber: min 0, maximo 11, no vacio, si ya existe no se debe duplicar

Select(Get)
-Se puede seleccionar todos
-Se puede seleccionar un id
-Si se manda un id diferente devuelve mensaje que el id no existe(Tanto en postman como en java log)


Update(Put)
-Validacion si existe ya por id, no duplicar
-Validacion por nombre: min 2, maximo 75, no vacio
-Validacion por apellido: min 2, maximo 75, no vacio
-Validacion por docnumber: min 0, maximo 11, no vacio, si ya existe no se debe duplicar
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
Productos(Validaciones en DB, Java y Postman)
Insert(POST)
-Validacion si existe ya por id, no duplicar
-Validacion por description: min 2, maximo 75, no vacio, no duplicar
-Validacion por code: min 2, maximo 50, no vacio, no duplicar
-Validacion por stock: min 0(OJO valor int)
-Validacion por price: min 0.0(OJO valor double)

Select(Get)
-Se puede seleccionar todos
-Se puede seleccionar un id
-Si se manda un id diferente devuelve mensaje que el id no existe(Tanto en postman como en java log)


Update(Put)
-Validacion si existe ya por id, no duplicar
-Validacion por description: min 2, maximo 75, no vacio, no duplicar
-Validacion por code: min 2, maximo 50, no vacio, no duplicar
-Validacion por stock: min 0(OJO valor int)
-Validacion por price: min 0.0(OJO valor double)
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
Factura(Validaciones en DB, Java y Postman)
Insert(POST)
-Validacion si existe ya por id, no duplicar
-Validacion en la entity para no agregar clientes con anotaciones JPA
-Validacion por fecha en el formato de anotacion JPA en Entity
-Validacion por price: min 0.0(OJO valor double)

Select(Get)
-Se puede seleccionar todos
-Se puede seleccionar un id
-Si se manda un id diferente devuelve mensaje que el id no existe(Tanto en postman como en java log)


Update(Put)
-Validacion si existe ya por id, no duplicar
-Validacion en la entity para no agregar clientes con anotaciones JPA(No lo muesta en la DB)
-Validacion por fecha en el formato de anotacion JPA en Entity
-Validacion por price: min 0.0(OJO valor double)
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
Detalles de la Factura(Validaciones en DB, Java y Postman)
Insert(POST)NOHECHOAUN--------------
-Validacion si existe ya por id, no duplicar
-Validacion en la entity para no agregar clientes con anotaciones JPA
-Validacion por fecha en el formato de anotacion JPA en Entity
-Validacion por price: min 0.0(OJO valor double)

Select(Get)
-Se puede seleccionar todos
-Se puede seleccionar un id
-Si se manda un id diferente devuelve mensaje que el id no existe(Tanto en postman como en java log)


Update(Put)
-Validacion si existe ya por id, no duplicar
-Validacion en la entity para no agregar clientes con anotaciones JPA(No lo muesta en la DB)
-Validacion por fecha en el formato de anotacion JPA en Entity
-Validacion por price: min 0.0(OJO valor double)
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------