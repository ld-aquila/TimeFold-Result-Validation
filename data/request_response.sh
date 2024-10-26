#! /bin/sh

# send to the solver the data
curl -X POST -H 'Content-Type:application/json' http://vehicle-routing:8080/route-plans -d@sample.json

# get the ID of the running job
job_id=$(curl -X GET http://vehicle-routing:8080/route-plans -H 'accept: application/json' | grep -o '[a-z0-9]\{8\}\-[a-z0-9]\{4\}\-[a-z0-9]\{4\}\-[a-z0-9]\{4\}\-[a-z0-9]\{12\}')

while :
do
  echo JobID: ${job_id}
  sleep 3

  # get the status of the solver
  status=$(curl -X GET http://vehicle-routing:8080/route-plans/${job_id} -H 'accept: application/json'| grep -o 'NOT_SOLVING')
  if [[ "${status}" == 'NOT_SOLVING' ]]; then
	  # get the results
	  curl -X GET http://vehicle-routing:8080/route-plans/${job_id} -H 'accept: application/json'
	  echo Done. Check the results file
	  break
  fi
done

