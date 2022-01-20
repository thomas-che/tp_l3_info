create or replace function NbAlbumPublic (email IN varchar2) return number 
IS
-- @param : email client string
-- return nb tt d'album visible
    nb number;
begin
    select count(*) into nb from Album where eMailClient=email and visibilite='Public';
    return(nb);
end;
/

select NbAlbumPublic('u1@') from dual;