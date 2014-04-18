<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
    </head>
<body id="userBodyId">
    <s:form id="userFormId" theme="simple">
        User Name : <s:textfield name="userForm.userName"/><br/>
        Password : <s:textfield name="userForm.password"/>
        <input type="button" name="SAVE" value="SAVE USER" onclick="saveUser();">
    </s:form>
</body>
<script type="text/javascript">
function saveUser(){
    makeAJaxCall('userBodyId', 'saveUser', 'userFormId')
}
</script>


