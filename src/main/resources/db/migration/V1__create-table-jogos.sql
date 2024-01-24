CREATE TABLE desenvolvedor (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    CONSTRAINT chk_nome CHECK (nome <> '') -- Verifica se o nome não está vazio
 );

CREATE TABLE console (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
     data_lancamento DATE,
     empresa VARCHAR(255),
     CONSTRAINT chk_nome_console CHECK (nome <> '') -- Verifica se o nome do console não está vazio
);

CREATE TABLE jogo (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   descricao TEXT,
   data_lancamento DATE,
   website VARCHAR(255),
   desenvolvedor_codigo INTEGER,
   genero VARCHAR(255),
   url_capa VARCHAR(255),
   CONSTRAINT fk_desenvolvedor FOREIGN KEY (desenvolvedor_codigo) REFERENCES desenvolvedor (codigo),
   CONSTRAINT chk_genero CHECK (genero IN ('FPS', 'outro_genero1', 'outro_genero2')), -- Adicione outros gêneros conforme necessário
   CONSTRAINT chk_data_lancamento CHECK (data_lancamento IS NULL OR data_lancamento >= '1900-01-01'),
   CONSTRAINT chk_website CHECK (website IS NULL OR website ~ '^https?://'), -- Verifica se a URL começa com http:// ou https://
   CONSTRAINT chk_url_capa CHECK (url_capa IS NULL OR url_capa ~ '^https?://') -- Verifica se a URL da capa começa com http:// ou https://
);

CREATE TABLE jogo_console (
    jogo_id INTEGER,
    console_codigo INTEGER,
    PRIMARY KEY (jogo_id, console_codigo),
    FOREIGN KEY (jogo_id) REFERENCES jogo (id),
    FOREIGN KEY (console_codigo) REFERENCES console (codigo)
);

-- Inserir um console de exemplo
--INSERT INTO console (codigo, nome, data_lancamento, empresa) VALUES (1, 'Playstation 5', '2013-05-01', 'Sony');
