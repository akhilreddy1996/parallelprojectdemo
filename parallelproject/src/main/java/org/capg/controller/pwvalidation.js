/**
 * 
 */

function validat()
{
	
var pw=f2.custPwd.value;
var cnfrmpw=f2.confimrCustPwd.value;
var dob=f2.dateOfbirth.value;
var parts=dob.split('-');

var inputdate=new Date(dob);

var todaydate=new Date();

if(pw===cnfrmpw)
	{
	
	  if(inputdate>todaydate)
		  {
		  document.getElementById('passwordErrMsg').innerHTML="invalid input date";
		  }
	  else
		  {
	  return  true;
		  }
	}
else
	{
	document.getElementById('passwordErrMsg').innerHTML="*pw and cfrm pw doesnt match." + inputdate;
  return false;
	}


}