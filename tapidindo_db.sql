drop database tapidindo;

CREATE DATABASE tapidindo;

USE tapidindo;

CREATE TABLE eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_evento DATE NOT NULL,
    localidade ENUM('Tapiocaria', 'Particular', 'Festival') NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SHOW TABLES;

DESCRIBE eventos;

INSERT INTO eventos (titulo, descricao, data_evento, localidade)
VALUES ('Festival de Tapioca', 'Um evento para promover as diversas variedades de tapioca.', '2024-11-01', 'Festival');

SELECT * FROM eventos;

-- Inserindo um evento do tipo "Festival"
INSERT INTO eventos (titulo, descricao, data_evento, localidade) 
VALUES ('Festival de Comidas Nordestinas', 
        'Festival gastronômico com diversas barracas de comida nordestina, incluindo tapiocas.', 
        '2024-11-10', 
        'Festival');

-- Inserindo dois eventos particulares
INSERT INTO eventos (titulo, descricao, data_evento, localidade) 
VALUES ('Aniversário de João Silva', 
        'Festa de aniversário particular, com buffet completo de tapiocas.', 
        '2024-12-02', 
        'Particular');

INSERT INTO eventos (titulo, descricao, data_evento, localidade) 
VALUES ('Confraternização da Empresa ABC', 
        'Evento privado de confraternização de final de ano com serviço personalizado de tapiocas.', 
        '2024-12-15', 
        'Particular');

-- Inserindo dois eventos na Tapiocaria
INSERT INTO eventos (titulo, descricao, data_evento, localidade) 
VALUES ('Tapioca Gourmet Night', 
        'Uma noite especial na Tapidindo Tapioca com tapiocas gourmet e música ao vivo.', 
        '2024-11-25', 
        'Tapiocaria');

INSERT INTO eventos (titulo, descricao, data_evento, localidade) 
VALUES ('Sábado Cultural na Tapidindo', 
        'Evento cultural com apresentações artísticas e um menu especial de tapiocas.', 
        '2024-12-09', 
        'Tapiocaria');

SELECT * FROM eventos;

SELECT * FROM eventos WHERE localidade = 'Tapiocaria';

SHOW CREATE TABLE eventos;

SELECT * FROM eventos WHERE data_evento > CURDATE();

SELECT * FROM eventos WHERE localidade = 'Tapiocaria';

CREATE TABLE sugestao_evento (
    id_sugestao INT AUTO_INCREMENT PRIMARY KEY,
    descricao TEXT NOT NULL,
    usuario_id VARCHAR(100),  -- Pode ser usado para armazenar um nome ou identificador do usuário
    data_sugestao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE contratacao_evento (
    id_contratacao INT AUTO_INCREMENT PRIMARY KEY,
    evento_id INT,
    data_contratacao DATE NOT NULL,
    nome_contratante VARCHAR(100) NOT NULL,
    contato VARCHAR(100) NOT NULL,
    status_reserva ENUM('reservada', 'fechada') DEFAULT 'reservada',
    FOREIGN KEY (evento_id) REFERENCES eventos(id) ON DELETE SET NULL
);

CREATE TABLE calendario_reservas (
    id_calendario INT AUTO_INCREMENT PRIMARY KEY,
    data_evento DATE NOT NULL,
    status ENUM('livre', 'preferencia', 'fechado') DEFAULT 'livre',
    evento_id INT,
    FOREIGN KEY (evento_id) REFERENCES eventos(id) ON DELETE SET NULL
);

-- Exemplo de inserção na tabela sugestao_evento
INSERT INTO sugestao_evento (descricao, usuario_id) VALUES ('Sugestão para um evento de Halloween', 'Cliente123');

-- Exemplo de inserção na tabela contratacao_evento
INSERT INTO contratacao_evento (evento_id, data_contratacao, nome_contratante, contato, status_reserva) 
VALUES (1, '2024-11-01', 'Maria da Silva', 'maria@exemplo.com', 'reservada');

-- Exemplo de inserção na tabela calendario_reservas
INSERT INTO calendario_reservas (data_evento, status, evento_id) VALUES ('2024-12-25', 'fechado', 2);

INSERT INTO sugestao_evento (descricao, usuario_id) 
VALUES ('Sugestão para um evento de Festa Junina', 'Cliente01');

-- Verifique o resultado
SELECT * FROM sugestao_evento;

-- Substitua "1" pelo valor de um "id" existente na tabela "eventos"
INSERT INTO contratacao_evento (evento_id, data_contratacao, nome_contratante, contato, status_reserva) 
VALUES (1, '2024-12-15', 'João da Silva', 'joao.silva@exemplo.com', 'reservada');

-- Verifique o resultado
SELECT * FROM contratacao_evento;

-- Teste de inserção com status padrão
INSERT INTO calendario_reservas (data_evento, status) 
VALUES ('2024-11-20', 'livre');

-- Verifique o resultado
SELECT * FROM calendario_reservas WHERE data_evento = '2024-11-20';

-- Atualize o status da data
UPDATE calendario_reservas 
SET status = 'fechado' 
WHERE data_evento = '2024-11-20';

-- Verifique o resultado
SELECT * FROM calendario_reservas WHERE data_evento = '2024-11-20';

-- Substitua "1" pelo valor do "id" de um evento que está vinculado a uma contratação
DELETE FROM eventos WHERE id = 1;

-- Verifique o resultado na tabela contratacao_evento
SELECT * FROM contratacao_evento WHERE evento_id IS NULL;




