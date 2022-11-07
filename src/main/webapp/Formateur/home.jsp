<jsp:include page="../components/header.jsp"/>
<jsp:include page="../components/navbar.jsp"/>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit" style="display: none">Logout</button>
</form>

<div class="flex justify-center p-10 bg-[#f0f0f0]">
    <div class="w-4/5">
        <div class="relative sm:rounded-lg">
            <table class="w-full text-sm text-left text-gray-500">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50">
                <tr>
                    <th scope="col" class="py-3 px-6">
                        Product name
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Color
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Category
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Price
                    </th>
                    <th scope="col" class="py-3 px-6">

                    </th>
                </tr>
                </thead>
                <tbody>
                    <tr class="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                        <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                            Apple MacBook Pro 17
                        </th>
                        <td class="py-4 px-6">
                            Sliver
                        </td>
                        <td class="py-4 px-6">
                            Laptop
                        </td>
                        <td class="py-4 px-6">
                            $2999
                        </td>
                        <td class="flex justify-center gap-8 py-4 px-6">
                            <button type="button" class=""><jsp:include page="../svg/edit.jsp"/></button>
                            <button type="button"><jsp:include page="../svg/delete.jsp"/></button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!--<div class="mt-5">
    <jsp:include page="../components/footer.jsp"/>
</div>
-->