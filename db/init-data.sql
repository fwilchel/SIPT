--
-- Softstudio
-- Copyrigth .MMXV.
--
-- Init Data Script
-- @author: Diego Poveda, <diego.poveda@softstudioo.co>.
-- @version: 1.0
--

--
-- TOC entry 2147 (class 0 OID 16440)
-- Dependencies: 181
-- Data for Name: lista; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO lista VALUES (1, 'arl', '');
INSERT INTO lista VALUES (2, 'banco', '');
INSERT INTO lista VALUES (3, 'cajacompensacion', '');
INSERT INTO lista VALUES (4, 'cargo', '');
INSERT INTO lista VALUES (5, 'eps', '');
INSERT INTO lista VALUES (6, 'estadovivil', '');
INSERT INTO lista VALUES (7, 'fondocesantias', '');
INSERT INTO lista VALUES (8, 'fondopensiones', '');
INSERT INTO lista VALUES (9, 'genero', '');
INSERT INTO lista VALUES (10, 'macroproyecto', '');
INSERT INTO lista VALUES (11, 'parentesco', '');
INSERT INTO lista VALUES (12, 'rh', '');
INSERT INTO lista VALUES (13, 'sino', '');
INSERT INTO lista VALUES (14, 'tipocontrato', '');
INSERT INTO lista VALUES (15, 'tipocuenta', '');
INSERT INTO lista VALUES (16, 'tipodotacion', '');
INSERT INTO lista VALUES (17, 'tipoempresa', '');
INSERT INTO lista VALUES (18, 'tipoformacion', '');
INSERT INTO lista VALUES (19, 'tipoidentificacion', '');
INSERT INTO lista VALUES (20, 'tiposoporte', '');

--
-- TOC entry 2149 (class 0 OID 16451)
-- Dependencies: 183
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (1, 1, 'SURA', 'SURA', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (2, 2, 'Bancolombia', 'Bancolombia', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (3, 3, 'Compensar', 'Compensar', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (4, 4, 'Gerente', 'Gerente', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (5, 5, 'Sanitas', 'Sanitas', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (6, 6, 'Casado/a', 'Casado/a', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (7, 7, 'Porvenir', 'Porvenir', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (8, 8, 'Porvenir', 'Porvenir', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (9, 9, 'Masculino', 'Masculino', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (10, 10, 'Macroproyecto uno', 'Macroproyecto uno', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (11, 11, 'Hermano/a', 'Hermano/a', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (12, 12, 'B+', 'B+', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (13, 13, 'Si', 'Si', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (14, 14, 'Prestación de Servicios', 'Prestación de Servicios', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (15, 15, 'Ahorros', 'Ahorros', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (16, 16, 'Completa', 'Completa', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (17, 17, 'Publica', 'Publica', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (18, 18, 'Tecnica', 'Tecnica', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (19, 19, 'CC', 'CC', true);
INSERT INTO item (id, lista, nombre, descripcion, estado) VALUES (20, 20, 'Fisico', 'Fisico', true);

--
-- TOC entry 2141 (class 0 OID 16409)
-- Dependencies: 175
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO departamento (id, nombre, descripcion) VALUES (1, 'Cundinamarca', 'Cundinamarca');

--
-- TOC entry 2143 (class 0 OID 16420)
-- Dependencies: 177
-- Data for Name: municipio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO municipio (id, departamento, nombre, descripcion) VALUES (1, 1, 'Bogotá', 'Bogotá');

--
-- TOC entry 2145 (class 0 OID 16431)
-- Dependencies: 179
-- Data for Name: centro_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO centro_medico (id, nit, nombre, direccion, municipio, telefono, contacto, estado) VALUES (1, '1234567890', 'MedicCenter', 'MedicCenter', 1, '1234567', 'Pepe Grillo', true);

--
-- TOC entry 2139 (class 0 OID 16397)
-- Dependencies: 173
-- Data for Name: centro_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO centro_trabajo (id, nombre, descripcion, direccion, estado) VALUES (1, 'Contabilidad', 'Contabilidad', 'calle falsa 123', true);
