<%@ page import="java.util.List" %>
<%@ page import="com.example.simploncloneweb.Entity.Brief" %>
<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>

<%
    String promoName = (String) session.getAttribute("promoName");
%>

<div class="w-full bg-[#f0f0f0]" style="height: 100vh;">
    <div class="flex flex-col gap-20 w-full bg-[#f0f0f0]" style="height: 100vh;">
        <div class="flex flex-col items-center mt-14 relative sm:rounded-lg">
            <div class="flex justify-center m-6" style="gap: 66.3rem">
                <div class="text-xl text-red-600 font-semibold">Promo&nbsp;<%=promoName%></div>
                <button type="button" data-modal-toggle="AddNewBriefModal" class="p-1 border-2 border-red-600 rounded-md text-sm font-semibold text-red-600">Ajouter brief</button>
            </div>
            <table class="w-3/4 text-sm text-left text-gray-500">
                <thead class="text-xs text-black uppercase bg-gray-50">
                <tr>
                    <th scope="col" class="py-3 px-6">
                        Brief Context
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Deadline
                    </th>
                    <th scope="col" class="py-3 px-6">

                    </th>
                </tr>
                </thead>
                <tbody>
                    <%
                        List<Brief> briefs = (List<Brief>) request.getAttribute("briefs");
                        for(Brief brief : briefs)
                        {
                    %>
                            <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    <%=brief.getContext()%>
                                </th>
                                <td class="py-4 px-6">
                                    <%=brief.getDeadline()%>
                                </td>
                                <td class="flex justify-center py-4 px-6">
                                    <div class="flex items-center gap-8">
                                        <%
                                            if(!brief.getStatus())
                                            {
                                        %>
                                                <form action="/formateur/lancerBrief" method="POST">
                                                    <input type="hidden" name="idBrief" value="<%=brief.getId()%>">
                                                    <button type="submit" class="p-1 border-2 border-green-600 rounded-md text-xs font-bold text-green-800">
                                                        Lancer
                                                    </button>
                                                </form>
                                        <%
                                            }else{
                                        %>
                                                <button type="button" disabled class="p-1 border-2 border-gray-400 rounded-md text-xs font-bold text-gray-400">Lancer</button>
                                        <%
                                            }
                                        %>

                                        <button type="button" data-modal-toggle="<%=brief.getId()+"brief"%>"><jsp:include page="../svg/edit.jsp"/></button> <!-- Edit -->

                                        <form action="/formateur/deleteBrief" method="POST">
                                            <label>
                                                <input type="hidden" name="idBrief" value="<%=brief.getId()%>">
                                            </label>
                                            <button type="submit"><jsp:include page="../svg/delete.jsp"/></button> <!-- Delete -->
                                        </form>

                                        <!-- UpdateBriefModal -->
                                        <div id="<%=brief.getId()+"brief"%>" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
                                            <div class="relative p-4 w-full max-w-md h-full md:h-auto">
                                                <!-- Modal content -->
                                                <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                                                    <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="<%=brief.getId()+"brief"%>">
                                                        <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                                                        <span class="sr-only">Close modal</span>
                                                    </button>
                                                    <div class="py-6 px-6 lg:px-8">
                                                        <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Ajouter un nouveau brief</h3>
                                                        <form class="space-y-6" action="/formateur/updateBrief" method="POST">
                                                            <div>
                                                                <label for="updateContext" class="block mb-2 text-sm font-medium text-gray-900">Context</label>
                                                                <input name="context" value="<%=brief.getContext()%>" id="updateContext" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="context" required=""/>
                                                            </div>

                                                            <div>
                                                                <label for="updateDeadline" class="block mb-2 text-sm font-medium text-gray-900">deadline</label>
                                                                <input type="number" name="deadline" value="<%=brief.getDeadline()%>" id="updateDeadline" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="deadline" required="">
                                                            </div>
                                                            <div class="flex justify-between">
                                                                <input type="hidden" name="idBrief" value="<%=brief.getId()%>">
                                                                <button type="submit" class="w-full text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Modifier</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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

<!-- AddNewBriefModal -->
<div id="AddNewBriefModal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full justify-center items-center">
    <div class="relative p-4 w-full max-w-md h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="AddNewBriefModal">
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="py-6 px-6 lg:px-8">
                <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Ajouter un nouveau brief</h3>
                <form class="space-y-6" action="/formateur/addBrief" method="POST">
                    <div>
                        <label for="context" class="block mb-2 text-sm font-medium text-gray-900">Context</label>
                        <textarea name="context" rows="5" id="context" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="context" required=""></textarea>
                    </div>

                    <div>
                        <label for="deadline" class="block mb-2 text-sm font-medium text-gray-900">deadline</label>
                        <input type="number" name="deadline" id="deadline" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="deadline" required="">
                    </div>
                    <div class="flex justify-between">
                        <button type="submit" class="w-full text-white bg-red-600 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Ajouter</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../components/footer.jsp"/>