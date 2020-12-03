-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'kanban';

DROP DATABASE kanban;

REVOKE ALL
ON ALL TABLES IN SCHEMA public
FROM kanban_owner;

REVOKE ALL
ON ALL SEQUENCES IN SCHEMA public
FROM kanban_owner;

DROP USER kanban_owner;

REVOKE ALL
ON ALL TABLES IN SCHEMA public
FROM kanban_appuser;

REVOKE ALL
ON ALL SEQUENCES IN SCHEMA public
FROM kanban_appuser;

DROP USER kanban_appuser;
