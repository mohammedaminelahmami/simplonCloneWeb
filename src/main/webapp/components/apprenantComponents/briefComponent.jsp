<%@ page import="java.util.List" %>
<%@ page import="com.example.simploncloneweb.Entity.Brief" %>
<div class="flex justify-center">
  <div class="p-4 bg-white rounded-md text-black mb-10" style="width: 70rem">
    <div class="m-10 text-xl font-semibold">Les briefs de ma promo</div>
    <div class="flex justify-center gap-4 m-10 flex-wrap">
      <%-- Default Cards --%>
      <!-- Card -->
      <div class="flex flex-col border-2 border-gray-200 rounded-xl" style="width: 20rem; height: 20rem">
        <div class="w-full">
          <img src="http://localhost/simplonImgs/brief1.jpg" class="w-full h-full rounded-t-xl" alt="">
        </div>
        <div class="self-center w-2/3">
          <div class="text-sm font-semibold mt-2">Application pour la gestion des reservations des trains</div>
        </div>
      </div>
      <!-- Card -->

      <!-- Card -->
      <div class="flex flex-col border-2 border-gray-200 rounded-xl" style="width: 20rem; height: 20rem">
        <div class="w-full">
          <img src="http://localhost/simplonImgs/brief3.png" class="w-full h-full rounded-t-xl" alt="">
        </div>
        <div class="self-center w-2/3">
          <div class="text-sm font-semibold mt-2">Minimal discord server</div>
        </div>
      </div>
      <!-- Card -->

      <!-- Card -->
      <div class="flex flex-col border-2 border-gray-200 rounded-xl" style="width: 20rem; height: 20rem">
        <div class="w-full">
          <img src="http://localhost/simplonImgs/1.png" class="w-full rounded-t-xl" style="height: 13.5rem" alt="">
        </div>
        <div class="self-center w-2/3">
          <div class="text-sm font-semibold mt-2">Creation d'un Plugin Wordpress</div>
        </div>
      </div>
      <!-- Card -->
      <%-- Default Cards --%>

      <%
        List<Brief> briefs = (List<Brief>) request.getAttribute("briefs");
        for(Brief brief : briefs)
        {
      %>
          <!-- getAllBriefs -->
          <!-- Card -->
          <div class="flex flex-col border-2 border-gray-200 rounded-xl" style="width: 20rem; height: 20rem">
            <div class="w-full">
              <img src="http://localhost/simplonImgs/imgBrief.png" class="w-full rounded-t-xl" style="height: 13.5rem" alt="">
            </div>
            <div class="self-center w-2/3">
              <div class="text-sm font-semibold mt-2"><%=brief.getContext()%></div>
            </div>
          </div>
          <!-- Card -->
          <!-- getAllBriefs -->
      <%
        }
      %>
    </div>
  </div>
</div>