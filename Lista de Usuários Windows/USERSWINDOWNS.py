import subprocess

def users_win():
    try:

        comando = ["net", "user"]
        resultado = subprocess.run(comando, capture_output=True, text=True, shell=True, check=True)

        saida = resultado.stdout.splitlines()

        usuarios = [
            line.strip() for line in saida
            if line.strip() and not line.startswith("---") and not line.lower().startswith("the command")
        ]

        if usuarios:
            print("Contas de usuários no Windows:")
            for usuario in usuarios:
                print(usuario)
        else:
            print("Nenhuma conta de usuário encontrada.")

    except subprocess.CalledProcessError as e:
        print(f"Erro ao executar o comando: {e}")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")

users_win()
