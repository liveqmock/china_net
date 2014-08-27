function isDigit(input)
{

	//var theMask = '0123456789.';
	var theMask = /\d/;

	//if (theMask.indexOf(input) == -1)
	if (!theMask.test(input))
	{
		return(false);
	}
	return(true);
}
function isInt(input)
{
	var flag = true;



		for(var loop = 0;loop < input.length;loop++)
		{
			if(isDigit(input.substring(loop,loop+1)) == false)
			{
				flag = false;
				break;
			}
		}

	return(flag);
}