set serveroutput on;
set verify off;
set feedback off;
accept nombre prompt 'Introduce nombre';
accept nota prompt 'Introduce nota';
DECLARE
resNota varchar2(20):=null;
begin	
if (&nota>=9) then
	resNota:='SOBRESALIENTE';
else if (&nota>5 and &nota<6) then
resNota:='APROBADO';
end if;
else if (&nota<5) then
	resNota:='INSUFICIENTE';
end if;
else if (&nota>6 and &nota<7) then
	resNota:='BIEN';
end if;
else if (&nota>7 and &nota<9) then
	resNota:='NOTABLE';
end if;
end if;
	dbms_output.put_line(&resNota);
end;
/
undefine &nombre;
undefine &nota; 