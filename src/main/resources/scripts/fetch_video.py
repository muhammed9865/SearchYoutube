import sys
import youtube_dl as ytdl
import json
import subprocess


class MyLogger(object):
    def debug(self, msg):
        pass

    def warning(self, msg):
        pass

    def error(self, msg):
        print(msg)



ydl_opts = {
    'noplaylist': True,
    'format' : 'best',
    'logger' : MyLogger()
}
ydl = ytdl.YoutubeDL(ydl_opts)
def fetch(url: str):
    with ydl:
        result = ydl.extract_info(url= url, download=False)
        
        response = {
            'id':result['id'],
            'title':result['title'],
            'url':result['url'],
            'description':result['description']
        }

        response = json.dumps(response)
        print(json.dumps(response))
        subprocess.run("clip", text=True, input=response)



if __name__ == "__main__":
    url = sys.argv[1]
    fetch(url= url)