import axios from "axios";

const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/employee-service/api/employees/get-emp";
const EMPLOYEE_ID = 11;

export const getEmployee = ()=>{
    return axios.get(EMPLOYEE_SERVICE_BASE_URL+"/"+EMPLOYEE_ID)
}