/**
 * 
 */

function validat()
{
	
var pw=f2.custPwd.value;
var cnfrmpw=f2.confimrCustPwd.value;

if(pw===cnfrmpw)
	{
	  return  true;
	}
else
	{
	document.getElementById('passwordErrMsg').innerHTML="*pw and cfrm pw doesnt match.";
  return false;
	}


}