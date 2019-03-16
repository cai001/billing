FROM docker/compose AS migration
COPY . .
RUN docker-compose build \
        --pull \
        --build-arg PGDATA=${PGDATA} \
        --build-arg POSTGRES_USER=${POSTGRES_USER} \
        --build-arg POSTGRES_PASSWORD=${POSTGRES_PASSWORD} \
        --build-arg POSTGRES_DB=${POSTGRES_DB} \
        database
RUN docker-compose build \
        --pull \
        --build-arg changeLogFile=${PATH_TO_LOG_FILE}/liquibase.yml \
        --build-arg username=${POSTGRES_USER} \
        --build-arg password=${POSTGRES_PASSWORD} \
        --build-arg url=jdbc:postgresql:databaase:5432/${POSTGRES_DB} \
        --build-arg driver=jdbc.postgresql.Driver \
        migration
RUN docker-compose up

FROM postgres
COPY --from=migration ${PGDATA} ${PGDATA}
ENTRYPOINT ["docker-entrypoint.sh"]
EXPOSE 5432
CMD ["postgres"]