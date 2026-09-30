ALTER TABLE productos
    DROP COLUMN prod_es_oferta,
    DROP COLUMN prod_es_mas_vendido;

ALTER TABLE autores
    DROP COLUMN aut_esta_vigente;

ALTER TABLE categorias
    DROP COLUMN cat_esta_vigente;

ALTER TABLE clientes
    DROP COLUMN cte_esta_vigente;

ALTER TABLE departamentos
    DROP COLUMN dep_esta_vigente;

ALTER TABLE domicilios
    DROP COLUMN dom_esta_vigente;

ALTER TABLE editoriales
    DROP COLUMN edit_esta_vigente;

ALTER TABLE localidades
    DROP COLUMN loc_esta_vigente;

ALTER TABLE paises
    DROP COLUMN pais_esta_vigente;

ALTER TABLE productos
    DROP COLUMN prod_esta_vigente;

ALTER TABLE provincias
    DROP COLUMN prov_esta_vigente;

ALTER TABLE subcategorias
    DROP COLUMN subcat_esta_vigente;

ALTER TABLE usuarios
    DROP COLUMN usr_esta_activo;