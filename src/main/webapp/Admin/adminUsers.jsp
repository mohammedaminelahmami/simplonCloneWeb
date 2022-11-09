<%@ page import="java.util.List" %>
<%@ page import="com.example.simploncloneweb.Entity.Apprenant" %>
<%@ page import="com.example.simploncloneweb.Entity.Formateur" %>
<%@ page import="com.example.simploncloneweb.Entity.Promotion" %>
<jsp:include page="../components/header.jsp"/>

<div>
    <jsp:include page="../components/adminComponents/navBar.jsp"/>
</div>

<div class="flex gap-20">
    <div class="">
        <aside class="w-64" aria-label="Sidebar">
            <div style="height: 100%" class="overflow-y-auto py-4 px-3 bg-gray-50 rounded dark:bg-gray-800">
                <ul class="flex flex-col gap-8 space-y-2 mt-10">
                    <li>
                        <a href="/dashboard" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path><path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path></svg>
                            <span class="ml-3">Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a href="/admin/users" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z"></path><path d="M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z"></path></svg>
                            <span class="flex-1 ml-3 whitespace-nowrap">Gerer les utilisateurs</span>
                        </a>
                    </li>
                    <li>
                        <button type="button" data-modal-toggle="promoModal" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"></path></svg>
                            <span class="flex-1 ml-3 whitespace-nowrap">Ajouter Promo</span>
                        </button>
                    </li>
                    <li>
                        <button type="button" data-modal-toggle="apprenantModal" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z" clip-rule="evenodd"></path></svg>
                            <span class="flex-1 ml-3 whitespace-nowrap">Ajouter Apprenant</span>
                        </button>
                    </li>
                    <li>
                        <button type="button" data-modal-toggle="formateurModal" class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z"></path><path d="M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z"></path></svg>
                            <span class="flex-1 ml-3 whitespace-nowrap">Ajouter Formateur</span>
                        </button>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/logout" style="margin-top: 25.5rem" class=" flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                            <svg aria-hidden="true" class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z" clip-rule="evenodd"></path></svg>
                            <span class="flex-1 ml-3 whitespace-nowrap">Se deconnecter</span>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
    </div>

    <%------------%>
        <div class="flex flex-col gap-20 w-4/5 mt-14">
            <div class="relative sm:rounded-lg">
                <div class="text-xl text-blue-700 font-semibold m-4">Les&nbsp;Formateurs</div>
                <table class="w-full text-sm text-left text-gray-500">
                    <thead class="text-xs text-black uppercase bg-gray-50">
                    <tr>
                        <th scope="col" class="py-3 px-6">
                            Nom & Prenom
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Username
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Email
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Promotion
                        </th>
                        <th scope="col" class="py-3 px-6">

                        </th>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Formateur> listFormateur = (List<Formateur>) request.getAttribute("listFormateur");
                            for(Formateur formateur : listFormateur)
                            {
                        %>
                            <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <%=formateur.getNom()%> <%=formateur.getPrenom()%>
                                </th>
                                <td class="py-4 px-6">
                                    <%=formateur.getUsername()%>
                                </td>
                                <td class="py-4 px-6">
                                    <%=formateur.getEmail()%>
                                </td>
                                <td class="py-4 px-6">
                                    Promo
                                </td>
                                <td class="flex justify-center gap-8 py-4 px-6">
                                    <button type="button" data-modal-toggle=<%=formateur.getId()+"formateur"%>><jsp:include page="../svg/edit.jsp"/></button> <!-- Edit -->

                                    <form action="/admin/delete" method="POST">
                                        <label>
                                            <input type="hidden" name="action" value="formateur">
                                            <input type="hidden" name="id" value="<%=formateur.getId()%>">
                                        </label>
                                        <button type="submit"><jsp:include page="../svg/delete.jsp"/></button> <!-- Delete -->
                                    </form>

                                    <!-- ThisModal -->
                                    <%--EditModal--%>
                                    <div id="<%=formateur.getId()+"formateur"%>" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
                                        <div class="relative p-4 w-full max-w-md h-full md:h-auto">
                                            <!-- Modal content -->
                                            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                                                <button data-modal-toggle="<%=formateur.getId()+"formateur"%>" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white">
                                                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                    <span class="sr-only">Close modal</span>
                                                </button>
                                                <div class="py-6 px-6 lg:px-8">
                                                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Edit</h3>
                                                    <form class="space-y-6" action="/admin/edit" method="post">
                                                        <div>
                                                            <label for="nome" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Nom</label>
                                                            <input type="text" name="nom" value="<%=formateur.getNom()%>" placeholder="Nom" id="nome" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div>
                                                            <label for="prnom" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Prenom</label>
                                                            <input type="text" name="prenom" value="<%=formateur.getPrenom()%>" placeholder="Prenom" id="prnom" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div>
                                                            <label for="Email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Email</label>
                                                            <input type="email" name="email" value="<%=formateur.getEmail()%>" placeholder="name@company.com" id="Email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div>
                                                            <label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Username</label>
                                                            <input type="text" name="username" value="<%=formateur.getUsername()%>" placeholder="Username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white">
                                                        </div>
                                                        <div>
                                                            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Mot de passe</label>
                                                            <input type="password" name="password" value="<%=formateur.getPassword()%>" placeholder="Mot de passe" id="password" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div class="hidden">
                                                            <label>
                                                                <input type="hidden" name="id" value="<%=formateur.getId()%>">
                                                                <input type="hidden" name="action" value="formateur">
                                                            </label>
                                                        </div>
                                                        <div class="flex justify-between">
                                                            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%--EditModal--%>
                                    <!-- ThisModal -->
                                </td>
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <div class="relative sm:rounded-lg">
                <div class="text-xl text-blue-700 font-semibold m-4">Les&nbsp;Apprenants</div>
                <table class="w-full text-sm text-left text-gray-500">
                    <thead class="text-xs text-black uppercase bg-gray-50">
                    <tr>
                        <th scope="col" class="py-3 px-6">
                            Nom & Prenom
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Username
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Email
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Promotion
                        </th>
                        <th scope="col" class="py-3 px-6">

                        </th>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Apprenant> listApprenant = (List<Apprenant>) request.getAttribute("listApprenant");
                            for(Apprenant apprenant : listApprenant)
                            {
                        %>
                            <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <%=apprenant.getNom()%> <%=apprenant.getPrenom()%>
                                </th>
                                <td class="py-4 px-6">
                                    <%=apprenant.getUsername()%>
                                </td>
                                <td class="py-4 px-6">
                                    <%=apprenant.getEmail()%>
                                </td>
                                <td class="py-4 px-6">
                                    Promo
                                </td>
                                <td class="flex justify-center gap-8 py-4 px-6">

                                    <button type="button" data-modal-toggle=<%=apprenant.getId()+"apprenant"%>><jsp:include page="../svg/edit.jsp"/></button> <!-- Edit -->

                                    <form action="/admin/delete" method="POST">
                                        <label>
                                            <input type="hidden" name="action" value="apprenant">
                                            <input type="hidden" name="id" value="<%=apprenant.getId()%>">
                                        </label>
                                        <button type="submit"><jsp:include page="../svg/delete.jsp"/></button> <!-- Delete -->
                                    </form>
                                    <!-- ThisModal -->
                                        <%--EditModal--%>
                                        <div id="<%=apprenant.getId()+"apprenant"%>" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
                                            <div class="relative p-4 w-full max-w-md h-full md:h-auto">
                                                <!-- Modal content -->
                                                <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                                                    <button data-modal-toggle="<%=apprenant.getId()+"apprenant"%>" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white">
                                                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                        <span class="sr-only">Close modal</span>
                                                    </button>
                                                    <div class="py-6 px-6 lg:px-8">
                                                        <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Edit</h3>
                                                        <form class="space-y-6" action="/admin/edit" method="post">
                                                            <div>
                                                                <label for="nomeE" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Nom</label>
                                                                <input type="text" name="nom" value="<%=apprenant.getNom()%>" placeholder="Nom" id="nomee" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                            </div>
                                                            <div>
                                                                <label for="prnomE" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Prenom</label>
                                                                <input type="text" name="prenom" value="<%=apprenant.getPrenom()%>" placeholder="Prenom" id="prnomE" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                            </div>
                                                            <div>
                                                                <label for="EmailE" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Email</label>
                                                                <input type="email" name="email" value="<%=apprenant.getEmail()%>" placeholder="name@company.com" id="EmailE" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                            </div>
                                                            <div>
                                                                <label for="usernameE" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Username</label>
                                                                <input type="text" name="username" value="<%=apprenant.getUsername()%>" placeholder="Username" id="usernameE" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white">
                                                            </div>
                                                            <div>
                                                                <label for="passwordE" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Mot de passe</label>
                                                                <input type="password" name="password" value="<%=apprenant.getPassword()%>" placeholder="Mot de passe" id="passwordE" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                            </div>
                                                            <div class="hidden">
                                                                <label>
                                                                    <input type="hidden" name="id" value="<%=apprenant.getId()%>">
                                                                    <input type="hidden" name="action" value="apprenant">
                                                                </label>
                                                            </div>
                                                            <div class="flex justify-between">
                                                                <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%--EditModal--%>
                                    <!-- ThisModal -->
                                </td>
                            </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <div class="flex flex-col gap-20 w-4/5 mt-14">
                    <div class="relative sm:rounded-lg">
                        <div class="text-xl text-blue-700 font-semibold m-4">Les&nbsp;Promos</div>
                        <table class="w-full text-sm text-left text-gray-500">
                            <thead class="text-xs text-black uppercase bg-gray-50">
                            <tr>
                                <th scope="col" class="py-3 px-6">
                                    Promotion
                                </th>
                                <th scope="col" class="py-3 px-6">
                                    Annee
                                </th>
                                <th scope="col" class="py-3 px-6">
                                    Statut
                                </th>
                                <th scope="col" class="py-3 px-6">

                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                List<Promotion> listPromotion = (List<Promotion>) request.getAttribute("listPromotion");
                                for(Promotion promotion : listPromotion)
                                {
                            %>
                            <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <%=promotion.getName()%>
                                </th>
                                <td class="py-4 px-6">
                                    <%=promotion.getAnnee()%>
                                </td>
                                <td class="py-4 px-6">
                                    <%=promotion.getStatus()%>
                                </td>
                                <td class="flex justify-center gap-8 py-4 px-6">
                                    <button type="button" data-modal-toggle=<%=promotion.getId()+"promotion"%>><jsp:include page="../svg/edit.jsp"/></button> <!-- Edit -->

                                    <form action="/admin/delete" method="POST">
                                        <label>
                                            <input type="hidden" name="action" value="promotion">
                                            <input type="hidden" name="id" value="<%=promotion.getId()%>">
                                        </label>
                                        <button type="submit"><jsp:include page="../svg/delete.jsp"/></button> <!-- Delete -->
                                    </form>

                                    <!-- ThisModal -->
                                    <%--EditModal--%>
                                    <div id="<%=promotion.getId()+"promotion"%>" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
                                        <div class="relative p-4 w-full max-w-md h-full md:h-auto">
                                            <!-- Modal content -->
                                            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                                                <button data-modal-toggle="<%=promotion.getId()+"promotion"%>" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white">
                                                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                    <span class="sr-only">Close modal</span>
                                                </button>
                                                <div class="py-6 px-6 lg:px-8">
                                                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Edit</h3>
                                                    <form class="space-y-6" action="/admin/edit" method="post">
                                                        <div>
                                                            <label for="namePromo" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Nom</label>
                                                            <input type="text" name="name" value="<%=promotion.getName()%>" placeholder="Nom" id="namePromo" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div>
                                                            <label for="anneePromo" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Prenom</label>
                                                            <input type="text" name="annee" value="<%=promotion.getAnnee()%>" placeholder="Prenom" id="anneePromo" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                                                        </div>
                                                        <div class="hidden">
                                                            <label>
                                                                <input type="hidden" name="id" value="<%=promotion.getId()%>">
                                                                <input type="hidden" name="action" value="promotion">
                                                            </label>
                                                        </div>
                                                        <div class="flex justify-between">
                                                            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Modifier</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%--EditModal--%>
                                    <!-- ThisModal -->
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
            </div>
        </div>
        <%------------%>
    </div>

    <!-- apprenantModal -->
    <div id="apprenantModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
        <div class="relative p-4 w-full max-w-md h-full md:h-auto">
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="apprenantModal">
                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                    <span class="sr-only">Close modal</span>
                </button>
                <div class="py-6 px-6 lg:px-8">
                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Ajouter apprenant</h3>
                    <form class="space-y-6" action="/admin/addAccount" method="post">
                        <div>
                            <label for="nomApprenant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Nom</label>
                            <input type="text" name="nom" id="nomApprenant" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Nom" required="">
                        </div>
                        <div>
                            <label for="prenomApprenant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Prenom</label>
                            <input type="text" name="prenom" id="prenomApprenant" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Prenom" required="">
                        </div>
                        <div>
                            <label for="emailApprenant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Email</label>
                            <input type="email" name="email" id="emailApprenant" placeholder="name@company.com" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                        </div>
                        <div>
                            <label for="usernameApprenant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Username</label>
                            <input type="text" name="username" id="usernameApprenant" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Username">
                        </div>
                        <div>
                            <label for="passwordApprenant" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Mot de passe</label>
                            <input type="password" name="password" id="passwordApprenant" placeholder="Mot de passe" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                        </div>
                        <div class="hidden">
                            <label>
                                <input type="hidden" name="action" value="apprenant">
                            </label>
                        </div>
                        <div class="flex justify-between">
                            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- formateurModal -->
    <div id="formateurModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
        <div class="relative p-4 w-full max-w-md h-full md:h-auto">
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="formateurModal">
                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                    <span class="sr-only">Close modal</span>
                </button>
                <div class="py-6 px-6 lg:px-8">
                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Ajouter formateur</h3>
                    <form class="space-y-6" action="/admin/addAccount" method="POST">
                        <div>
                            <label for="nom" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Nom</label>
                            <input type="text" name="nom" id="nom" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Nom" required="">
                        </div>
                        <div>
                            <label for="prenom" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Prenom</label>
                            <input type="text" name="prenom" id="prenom" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Prenom" required="">
                        </div>
                        <div>
                            <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Email</label>
                            <input type="email" name="email" id="emailF" placeholder="name@company.com" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                        </div>
                        <div>
                            <label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Username</label>
                            <input type="text" name="username" id="usernameF" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Username" required="">
                        </div>
                        <div>
                            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Mot de passe</label>
                            <input type="password" name="password" id="passwordF" placeholder="Mot de passe" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required="">
                        </div>
                        <div class="hidden">
                            <label>
                                <input type="hidden" name="action" value="formateur">
                            </label>
                        </div>
                        <div class="flex justify-between">
                            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- promoModal -->
    <div id="promoModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
        <div class="relative p-4 w-full max-w-md h-full md:h-auto">
            <!-- Modal content -->
            <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="promoModal">
                    <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                    <span class="sr-only">Close modal</span>
                </button>
                <div class="py-6 px-6 lg:px-8">
                    <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Ajouter promo</h3>
                    <form class="space-y-6" action="/admin/addPromo" method="POST">
                        <div>
                            <label for="Name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Name</label>
                            <input type="text" name="name" id="Name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Name" required="">
                        </div>

                        <div>
                            <label for="annee" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Annee</label>
                            <input type="number" name="annee" id="annee" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Annee" required="">
                        </div>
                        <div class="flex justify-between">
                            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</body>
</html>