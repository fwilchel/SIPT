--
-- Demiurgesoft
-- Copyrigth .MMXV.
--
-- Drop database script
-- @author: Javier Latorre, <javier.latorre@demiurgesoft.com>
-- @version: 1.0
--

-------------------------------------------------------------
-- To disconnect the users:
-------------------------------------------------------------
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'showroom'
AND pid <> pg_backend_pid();

DROP DATABASE showroom;
DROP ROLE showroom;