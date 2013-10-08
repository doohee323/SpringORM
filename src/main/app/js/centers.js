function go(url)
{
	window.location = url;
}

function newCenter()
{
	window.location = "saveCenter.do";
}

function deleteCenter(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}
