create or replace function NbAlbumPublic (email IN varchar2) return number as
    nb number;
begin
    select count(*) into nb from Album where eMailClient=email and visibilite='Public';
    return(nb);
end;
/

select NbAlbumPublic('u1@') from dual;