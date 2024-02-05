ALTER TABLE jogo_console
DROP CONSTRAINT IF EXISTS jogo_console_jogo_id_fkey,
DROP CONSTRAINT IF EXISTS jogo_console_console_codigo_fkey,
ADD CONSTRAINT jogo_console_jogo_id_fkey FOREIGN KEY (jogo_id) REFERENCES jogo(id) ON DELETE CASCADE,
ADD CONSTRAINT jogo_console_console_codigo_fkey FOREIGN KEY (console_codigo) REFERENCES console(codigo) ON DELETE CASCADE;