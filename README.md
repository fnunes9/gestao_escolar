# Gestão Escolar
Sistema de gestão escolar

🎯 Objetivo
Criar um sistema simples para gerenciar escolas, cursos e alunos, com interface gráfica usando jQuery, e backend em Spring Boot, com banco de dados PostgreSQL. O projeto tem fins educacionais, focado em praticar conceitos de CRUD, arquitetura, e integração entre front e back.

🧩 Entidades do Sistema
🏫 Escola
id: identificador único da escola

nome_escola: nome da escola

📚 Curso
id: identificador único do curso

nome_curso: nome do curso

👩‍🎓 Aluno
id: identificador único do aluno

nome: nome do aluno

id_curso: referência ao curso

id_escola: referência à escola

🔁 Cursos são independentes das escolas. Um mesmo curso pode ser vinculado a diferentes escolas (sem duplicação).

🛠️ Tecnologias
🔙 Backend:
Spring Boot

Banco: PostgreSQL

Framework ORM: Spring Data JPA

Mapeamento JSON: Jackson

Validação: Bean Validation

🔜 Frontend:
HTML + CSS + jQuery

Comunicação com backend via AJAX (fetch ou jQuery.ajax)

💡 Funcionalidades esperadas (CRUD)
Entidade	Operações
Escola	Criar, Listar, Editar, Deletar
Curso	Criar, Listar, Editar, Deletar
Aluno	Criar, Listar, Editar, Deletar + Vincular com escola e curso

📌 Decisões e princípios
Tudo será feito manualmente, sem scaffolding automático.

Front e back serão desacoplados.

O foco está em entender a lógica, não na escalabilidade.

Priorizei clareza, boas práticas e aprendizado progressivo.
