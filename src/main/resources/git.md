git branch -m oldname 16-create-Usersrest-controller-class

git checkout -b 37-Run-Web-Service-as-a-Standalone-Application;
git status;
git add .;
git commit -m "37. Run Web Service as a Standalone Application.";
git push -u origin 37-Run-Web-Service-as-a-Standalone-Application;

Right click on the Project
Go to Resources
copy app path

goto cmd
ls (to list all forders inside folder)

enter
D:  (switch to D drive)
cd "D:\Sushanth\mobile-app-ws-quick-start"

mvn install

ls target/*.* (List target folder files)
taget folder contains executable jar file

mvn clean(to remove target file)

java -jar target/mobile-app-ws-0.0.1-SNAPSHOT.jar (Run App)


D:\Sushanth\mobile-app-ws-quick-start

Apply Break Point 
And
Run In DEBUG Mode 

POSTMAPPING

http://localhost:8080/users

{
    "firstName":"Sergey",
    "lastName":"Kargo",
    "email":"test@test.com",
    "password": "123456789"
}

 <UserRest>
     <firstName>yrgey</firstName>
     <lastName>Kargo</lastName>
     <email>test@test.com</email>
     <password>123456789</password>
 </UserRest>
 
 GET MAPPING
http://localhost:8080/users/38ce280a-d7eb-4440-a68d-f5810a7a7b92

DELETEMAPPING

http://localhost:8080/users/091b12da-445f-483b-98d5-405c20fee825

POSTMAN
headers

Content-Type application/json
Accept       application/json

PUTMAPPING
http://localhost:8080/users/647c91e0-90dc-4e5e-9f05-5cf920ef1fe9

<UserRest>
    <firstName>Sergey</firstName>
    <lastName>Kargo Kohli</lastName>
</UserRest>

{
    "firstName": "Sergey",
    "lastName": "Kargo Kohli",
}





