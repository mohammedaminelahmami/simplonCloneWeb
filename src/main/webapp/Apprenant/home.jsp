<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit" style="display: none">Logout</button>
</form>

<div class="bg-[#f0f0f0]">
    <div class="flex gap-4">
        <div class="mt-10" style="margin-left: 25rem">
            <img src="http://localhost/simplonImgs/profile.png" class="w-10 h-10" alt="">
        </div>
        <div class="mt-10">
            <div>Bonjour <span class="font-semibold">lahmami Mohammed Amine,</span></div>
            <div>Bienvenue sur Simplon</div>
        </div>

    </div>
    <div>
        <jsp:include page="../components/apprenantComponents/bodyPromo.jsp"/>
    </div>
</div>

<jsp:include page="../components/footer.jsp"/>