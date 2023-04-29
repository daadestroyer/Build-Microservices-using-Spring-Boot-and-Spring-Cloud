import React, { useEffect, useState } from 'react'
import EmployeeService, { getEmployee } from '../service/EmployeeService';


export const EmployeeComponent = () => {


    const [empData, setEmployeeData] = useState({
        employeeData: [],
        departmentData: [],
        organizationData: {}
    });

    const [errorData, setError] = useState({
        errors: {},
        isError: false
      })


    useEffect(() => {
        getEmployee()
            .then((resp) => {
                setEmployeeData(resp)
                console.log(resp)
              
            }).catch(error => {
                setError({
                    errors: error,
                    isError: true
                  })
                  console.log(errorData)
                console.log("something went wrong")
            })
    }, [])


    return (
        <div>
            <div className='container card'>
                <h3 className='text-left card-header'>Employee Details</h3>
                <p style={{color:'red'}}>{errorData?.errors?.response?.data?.message}</p>
                <p style={{color:'red'}}>{errorData?.errors?.response?.data?.status}</p>
                <p>{errorData?.isError}</p>
                <div className='row'>
                    {

                        ( 
                           errorData?.isError==false &&
                           <>
                                <div className='col-md-4'>
                                    <hr />
                                    <div className='card-body'>
                                        <div className='row'>
                                            <b><p>Employee Data</p></b>
                                            <p><strong>Id: </strong>{empData?.data?.employeeData?.id}</p>
                                            <p><strong>First Name: </strong>{empData?.data?.employeeData?.firstName}</p>
                                            <p><strong>Last Name: </strong>{empData?.data?.employeeData?.lastName}</p>
                                            <p><strong>Email: </strong>{empData?.data?.employeeData?.email}</p>
                                            <p><strong>Organization Code: </strong>{empData?.data?.employeeData?.orgCode}</p>
                                            <p><strong>Department Code: </strong>{empData?.data?.employeeData?.deptCode}</p>

                                        </div>
                                    </div>

                                </div>
                                <div className='col-md-4'>
                                    <hr />
                                    <div className='card-body'>
                                        <div className='row'>
                                            <b><p>Department Data</p></b>
                                            <p><strong>Id: </strong>{empData?.data?.departmentData?.id}</p>
                                            <p><strong>Dept Code: </strong>{empData?.data?.departmentData?.deptCode}</p>
                                            <p><strong>Dept Desc: </strong>{empData?.data?.departmentData?.deptDesc}</p>
                                            <p><strong>Dept Name: </strong>{empData?.data?.departmentData?.deptName}</p>

                                        </div>
                                    </div>
                                </div>
                                <div className='col-md-4'>
                                    <hr />
                                    <div className='card-body'>
                                        <div className='row'>
                                            <b><p>Organization Data</p></b>
                                            <p><strong>Id: </strong>{empData?.data?.organizationData?.id}</p>
                                            <p><strong>Organization Code: </strong>{empData?.data?.organizationData?.organizationCode}</p>
                                            <p><strong>Organization Name: </strong>{empData?.data?.organizationData?.organizationName}</p>

                                        </div>
                                    </div>
                                </div>
                            </>
                           
                        )
                    }

                </div>
            </div>
        </div>
    )
}

export default EmployeeComponent
