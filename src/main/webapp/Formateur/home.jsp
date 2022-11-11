<%@ page import="com.example.simploncloneweb.Entity.Apprenant" %>
<%@ page import="java.util.List" %>
<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>

<%--| Apprenant |--%>
<div class="flex flex-col gap-20 w-full bg-[#f0f0f0]">
    <div class="flex flex-col items-center mt-14 relative sm:rounded-lg">
        <div class="self-start text-xl text-red-600 font-semibold m-4" style="margin-left: 15rem">Tous Les&nbsp;Apprenants</div>
        <table class="w-3/4 text-sm text-left text-gray-500">
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
                            <td class="flex justify-center py-4 px-6">
                                <%
                                    if(apprenant.getIdpromo() == request.getAttribute("idPromo"))
                                    {
                                %>
                                    <div class="flex gap-6">
                                        <button type="button" disabled class="p-1 border-2 border-gray-400 rounded-md text-xs font-semibold text-gray-400">Assigner</button>

                                        <form action="#" method="POST">
                                            <button type="submit" class="p-1 border-2 border-black rounded-md text-xs font-semibold text-black">
                                                Empecher
                                            </button>
                                        </form>
                                    </div>
                                <%
                                    }else{
                                %>
                                    <div class="flex gap-6">
                                        <form action="/formateur/assign" method="POST">
                                            <input type="hidden" name="idApprenant" value="<%=apprenant.getId()%>">
                                            <button type="submit" class="p-1 border-2 border-black rounded-md text-xs font-semibold text-black">
                                                Assigner
                                            </button>
                                        </form>

                                        <button type="button" disabled class="p-1 border-2 border-gray-400 rounded-md text-xs font-semibold text-gray-400">Empecher</button>
                                    </div>
                                <%
                                    }
                                %>

                            </td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
<%--| Apprenant |--%>
<%
    String promoName = request.getParameter("promoName");
%>
<div class="flex flex-col gap-20 w-full bg-[#f0f0f0]">
    <div class="flex flex-col items-center mt-14 relative sm:rounded-lg">
        <div class="self-start text-xl text-red-600 font-semibold m-4" style="margin-left: 15rem">Promo&nbsp;<%=promoName%></div>
        <table class="w-3/4 text-sm text-left text-gray-500">
            <thead class="text-xs text-black uppercase bg-gray-50">
            <tr>
                <th scope="col" class="py-3 px-6">
                </th>
                <th scope="col" class="py-3 px-6">
                </th>
                <th scope="col" class="py-3 px-6">
                </th>
                <th scope="col" class="py-3 px-6">
                </th>
                <th scope="col" class="py-3 px-6">

                </th>
            </tr>
            </thead>
            <tbody>
                <%----%>
            </tbody>
        </table>
    </div>
</div>

<!--<div class="mt-5">
    <jsp:include page="../components/footer.jsp"/>
</div>
-->