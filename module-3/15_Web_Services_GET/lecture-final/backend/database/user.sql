-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER kanban_owner
WITH PASSWORD 'kanban';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO kanban_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO kanban_owner;

CREATE USER kanban_appuser
WITH PASSWORD 'kanban';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO kanban_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO kanban_appuser;
