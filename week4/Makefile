CC=gcc
CFLAGS=-W -Wall
SRCS=$(wildcard *.c)
OBJS=$(SRCS:.c=.o)

all: run
	@echo "Built Successfully"

run: $(OBJS)
	${CC} ${CFLAGS} -o $@ $^

clean:
	rm -rf *.o exe

